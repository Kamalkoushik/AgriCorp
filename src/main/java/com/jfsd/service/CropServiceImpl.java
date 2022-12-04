package com.jfsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Crop;
import com.jfsd.repository.CropRepo;

@Service
public class CropServiceImpl implements CropService
{
	@Autowired
	private CropRepo cropRepo;
	
	@Override
	public String addCrop(Crop crop) {
		cropRepo.save(crop);
		return "Crop Account Created Successfully";
	}

}
