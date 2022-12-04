package com.jfsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Crop;
import com.jfsd.model.Farmer;
import com.jfsd.model.Tips;
import com.jfsd.repository.CropRepo;
import com.jfsd.repository.FarmerRepo;
import com.jfsd.repository.TipsRepo;

@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	private FarmerRepo farmerrepo;
	
	@Autowired 
	private TipsRepo tipsRepo;
	
	@Autowired
	private CropRepo cropRepo;
	
	@Override
	public Farmer addFarmer(Farmer farmer) {
		return farmerrepo.save(farmer);
	}

	@Override
	public Farmer findByUsernameAndPassword(String username, String password) {
		return farmerrepo.findByUsernameAndPassword(username, password);
	}
	
	@Override
	public List<Tips> viewalltips()
	{
		return(List<Tips>)tipsRepo.findAll();
	}

	@Override
	public List<Crop> viewallcrops() 
	{
		return(List<Crop>)cropRepo.findAll();
	}
	@Override
	  public Farmer findById(int id) {
	    return farmerrepo.findById(id).get();
	  }
}
