package com.jfsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Admin;
import com.jfsd.model.Farmer;
import com.jfsd.model.Supplier;
import com.jfsd.repository.AdminRepo;
import com.jfsd.repository.FarmerRepo;
import com.jfsd.repository.SupplierRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminrepo;
	
	@Autowired
	private FarmerRepo farmerRepo;
	
	@Autowired
	private SupplierRepo supplierRepo;
	
	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		return adminrepo.checkadminlogin(username, password);
	}
	@Override
	public List<Farmer> viewallfarmers()
	{
		return (List<Farmer>)farmerRepo.findAll();
	}
	@Override
	public List<Supplier> viewallsuppliers()
	{
		List<Supplier> suppliers = (List<Supplier>) supplierRepo.findAll();
		return suppliers;
	}
	
	 @Override
	  public void deletefarmer(int id) {
	    farmerRepo.deleteById(id);
	  }
	  @Override
	  public void deletesupplier(int id) {
	    supplierRepo.deleteById(id);
	  }
	
}
