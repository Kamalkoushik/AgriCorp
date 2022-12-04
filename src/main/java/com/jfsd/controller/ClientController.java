package com.jfsd.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.model.Admin;
import com.jfsd.model.Complain;
import com.jfsd.model.Crop;
import com.jfsd.model.Farmer;
import com.jfsd.model.SellCrop;
import com.jfsd.model.Supplier;
import com.jfsd.model.Tips;
import com.jfsd.service.AdminService;
import com.jfsd.service.ComplainService;
import com.jfsd.service.CropService;
import com.jfsd.service.FarmerService;
import com.jfsd.service.SellCropService;
import com.jfsd.service.SupplierService;
import com.jfsd.service.TipsService;

@Controller
public class ClientController {
	
	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private ComplainService complainservice;
	
	@Autowired
	private AdminService adminservice;
	
	@Autowired 
	private SupplierService supplierService;
	
	@Autowired
	private TipsService tipsService;
	
	@Autowired
	private CropService cropService;
	
	@Autowired
	private SellCropService sellcropService;
	
	@GetMapping("/Home")
	public ModelAndView homepage() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/About")
	public ModelAndView aboutpage() {
		return new ModelAndView("about");
	}
	
	@GetMapping("/FarmerLogin")
	public ModelAndView Farmerlogin() {
		return new ModelAndView("FarmerLogin");
	}
	
	@GetMapping("/AdminLogin")
	public ModelAndView Adminlogin() {
		return new ModelAndView("AdminLogin");
	}
	
	@GetMapping("/Contact")
	public ModelAndView contact() {
		return new ModelAndView("contact");
	}
	
	@GetMapping("/FarmerHome")
	public ModelAndView FarmerHome() {
		return new ModelAndView("farmerhome");
	}
	
	
	@GetMapping("/FarmerRegister")
	public ModelAndView FarmerRegister() {
		return new ModelAndView("FarmerRegister", "farmer", new Farmer());
	}
	
	@PostMapping("/checkfarmerlogin")
	public ModelAndView checkfarmerdemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String funame=request.getParameter("funame");
		String fpwd=request.getParameter("fpwd");
		
		Farmer farmer = farmerService.findByUsernameAndPassword(funame, fpwd);
		
		if(farmer!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("euname", funame);
			mv.setViewName("farmerhome");
		}
		else
		{
			mv.setViewName("FarmerLogin");
			mv.addObject("msg","Login Failed");
		}
		return mv;
	}
	
	@PostMapping("/addfarmerdetails")
	public String addfarmerdemo(@ModelAttribute("farmer") Farmer farmer)
	{
		farmerService.addFarmer(farmer); 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FarmerRegister");
		mv.addObject("msg", "Registration Successfull");
		return "redirect:FarmerLogin";
	}
	
	@PostMapping("/checkadminlogin")
	public ModelAndView checkadmindemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String auname=request.getParameter("auname");
		String apwd=request.getParameter("apwd");
		
		Admin admin = adminservice.checkadminlogin(auname, apwd);
		
		if(admin!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("auname", auname);
			mv.setViewName("adminhome");
		}
		else
		{
			mv.setViewName("AdminLogin");
			mv.addObject("msg","Login Failed");
		}
		return mv;
	}
	
	@GetMapping("/viewallfarmers")
	public ModelAndView viewallfarmersdemo()
	{
		ModelAndView mv = new ModelAndView("viewallfarmers");
		List<Farmer> farmerlist=adminservice.viewallfarmers();
		mv.addObject("farmerlist",farmerlist);
		return mv;
	}
	
	@GetMapping("/viewallsuppliers")
	public ModelAndView viewallsuppliersdemo()
	{
		ModelAndView mv = new ModelAndView("viewallsuppliers");
		List<Supplier> supplierlist=adminservice.viewallsuppliers();
		mv.addObject("supplierlist",supplierlist);
		return mv;
	}
	
	@GetMapping("/complainpage")
	public ModelAndView complainpage(){
		return new ModelAndView("ComplainPage", "comp", new Complain());
	}
	
	@GetMapping("/ComplainPage")
	public ModelAndView ComplainPage(){
		return new ModelAndView("ComplainPage");
	}
	
	@PostMapping("/addcomplain")
	public String addcomplain(@ModelAttribute("comp") Complain comp) {
		complainservice.addComplain(comp);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ComplainPage");
		mv.addObject("msg", "Complaint Posted");
		return "redirect:farmerhomenav";
	}
	
	@GetMapping("/SupplierLogin")
	public ModelAndView Supplierlogin() {
		return new ModelAndView("SupplierLogin");
	}
	
	@GetMapping("/SupplierRegister")
	public ModelAndView SupplierRegister() {
		return new ModelAndView("SupplierRegister", "supplier", new Supplier());
	}
	
	@PostMapping("/addsupplierdetails")
	public String addsupplierdemo(@ModelAttribute("supplier") Supplier supplier)
	{
		supplierService.addSupplier(supplier);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SupplierRegister");
		mv.addObject("msg", "Registration Successfull");
		return "redirect:SupplierLogin";
	}
	
	@PostMapping("/checksupplierlogin")
	public ModelAndView checksupplierdemo(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String suname=request.getParameter("suname");
		String spwd=request.getParameter("spwd");
		
		Supplier supplier= supplierService.findByUsernameAndPassword(suname, spwd);
		
		if(supplier!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("euname", suname);
			mv.setViewName("supplierhome");
		}
		else
		{
			mv.setViewName("SupplierLogin");
			mv.addObject("msg","Login Failed");
		}
		return mv;
	}
	
	@GetMapping("/addtips")
	public ModelAndView navigateToTipsPage()
	{
		ModelAndView mv = new ModelAndView("tips");
		return mv;
	}
	
	@PostMapping("/addatip")
	public ModelAndView addtips(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tips");
		String message = request.getParameter("tip");
		Tips tips = new Tips();
		tips.setTip(message);
		tipsService.addTips(tips);
		mv.addObject("msg", "Tip added Successfull");
		return mv;
	}
	
	@GetMapping("/farmerregister")
	public ModelAndView farmerregister() {
		return new ModelAndView("AddFarmer", "farmer", new Farmer());
	}
	
	@PostMapping("/addfarmer")
	public String addfarmer(@ModelAttribute("farmer") Farmer farmer)
	{
		farmerService.addFarmer(farmer); 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddFarmer");
		mv.addObject("msg", "New record added Successfully");
		return "redirect:viewallfarmers";
	}
	
	@GetMapping("/supplierregister")
	public ModelAndView supplierregister() {
		return new ModelAndView("AddSupplier", "supplier", new Supplier());
	}
	
	@PostMapping("/addsupplier")
	public String addsupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		supplierService.addSupplier(supplier);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddSupplier");
		mv.addObject("msg", "New Reciord added Successfull");
		return "redirect:viewallsuppliers";
	}
	
	@GetMapping("/AddCropDetails")
	public ModelAndView AddCropDetails() {
		return new ModelAndView("addadvertisement", "crop", new Crop());
	}
	
	@PostMapping("/addAdvertisement")
	public String addAdvertisement(@ModelAttribute("crop") Crop crop)
	{
		cropService.addCrop(crop);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addadvertisement");
		mv.addObject("msg", "Added Successfull");
		return "redirect:supplierhomenav";
	}
	
	@GetMapping("/addsellcroppage")
	public ModelAndView addsellcroppage(){
		return new ModelAndView("addsellcrop", "sellcrop", new SellCrop());
	}
	
	@GetMapping("/AddSellCropPage")
	public ModelAndView AddSellCropPage()
	{
		return new ModelAndView("addsellcrop");
	}
	
	@PostMapping("/addSellcrop")
	public String addSellcrop(@ModelAttribute("sellcrop") SellCrop sellCrop) 
	{
		sellcropService.addSellCrop(sellCrop);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellcrop");
		mv.addObject("msg", "Sell Crop Added");
		return "redirect:farmerhomenav";
	}
	
	@GetMapping("/viewallsellcrops")
	public ModelAndView viewallsellcrops()
	{
		ModelAndView mv = new ModelAndView("viewallsellcrops");
		List<SellCrop> sellcroplist=supplierService.viewallsellcrops();
		mv.addObject("sellcroplist",sellcroplist);
		return mv;
	}
	
	@GetMapping("/adminhomenav")
	public ModelAndView adminhome() 
	{
		return new ModelAndView("adminhome");
	}
	
	@GetMapping("/supplierhomenav")
	public ModelAndView supplierhome() 
	{
		return new ModelAndView("supplierhome");
	}
	
	@GetMapping("/farmerhomenav")
	public ModelAndView farmerhome() 
	{
		return new ModelAndView("farmerhome");
	}
	
	@GetMapping("/viewallcrops")
	  public ModelAndView viewallcropsdemo()
	  {
	    ModelAndView mv = new ModelAndView("viewallcrops");
	    List<Crop> cropslist=farmerService.viewallcrops();
	    mv.addObject("cropslist",cropslist);
	    return mv;
	  }
	
	@GetMapping("/viewalltips")
	public ModelAndView viewalltipssdemo()
	{
		ModelAndView mv = new ModelAndView("viewalltips");
		List<Tips> tipslist=farmerService.viewalltips();
		mv.addObject("tipslist",tipslist);
		return mv;
	}
	
	 @GetMapping("/deletefarmer")
	  public String deletefarmer(@RequestParam("id") int fid)
	  {
	    adminservice.deletefarmer(fid);
	    return "redirect:viewallfarmers";
	  }
	  
	  @GetMapping("/deletesupplier")
	  public String deletesupplier(@RequestParam("id") int sid)
	  {
	    adminservice.deletesupplier(sid);
	    return "redirect:viewallsuppliers";
	  }
	  
	  @PostMapping("updatefarmer")
	  public ModelAndView updateFarmerDetails(HttpServletRequest request)
	  {
	    ModelAndView modelAndView = new ModelAndView();
	    int id = Integer.parseInt(request.getParameter("idfarm"));
	    Farmer farmer = farmerService.findById(id);
	    String email = request.getParameter("mailid");
	    String mobile = request.getParameter("phonenum");
	    farmer.setContactno(mobile);
	    farmer.setEmail(email);
	    farmerService.addFarmer(farmer);
	    modelAndView.setViewName("viewallfarmers");
	    modelAndView.addObject("farmerlist", adminservice.viewallfarmers());
	    return modelAndView;
	  }
	  
	  @GetMapping("farmerupdate")
	  public ModelAndView updatefarmer(@RequestParam("id") int id) {
	    ModelAndView mv = new ModelAndView("updatefarmer");
	    mv.addObject("id", id);
	    return mv;
	  }
	  
	  @PostMapping("updatesupplier")
	  public ModelAndView updateSupplierDetails(HttpServletRequest request)
	  {
	    ModelAndView modelAndView = new ModelAndView();
	    int id = Integer.parseInt(request.getParameter("idsupp"));
	    Supplier supplier = supplierService.findById(id);
	    String email = request.getParameter("mailid");
	    String mobile = request.getParameter("phonenum");
	    supplier.setPhone_number(mobile);
	    supplier.setEmail(email);
	    supplierService.addSupplier(supplier);
	    modelAndView.setViewName("viewallsuppliers");
	    modelAndView.addObject("supplierlist", adminservice.viewallsuppliers());
	    return modelAndView;
	  }
	  
	  @GetMapping("supplierupdate")
	  public ModelAndView updatesupplier(@RequestParam("id") int id) {
	    ModelAndView mv = new ModelAndView("updatesupplier");
	    mv.addObject("id", id);
	    return mv;
	  }

	
}
