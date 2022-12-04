package com.jfsd.service;
import java.util.List;

import com.jfsd.model.Crop;
import com.jfsd.model.Farmer;
import com.jfsd.model.Tips;

public interface FarmerService {

	public Farmer addFarmer(Farmer farmer); 
	public Farmer findByUsernameAndPassword(String username, String password);
	public List<Tips> viewalltips();
	public List<Crop> viewallcrops();
	public Farmer findById(int id);
}
