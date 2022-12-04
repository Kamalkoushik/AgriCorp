package com.jfsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Crop;
import com.jfsd.model.SellCrop;
import com.jfsd.repository.SellCropRepo;

@Service
public class SellCropServiceImpl implements SellCropService
{
	@Autowired
	private SellCropRepo sellcropRepo;

	@Override
	public String addSellCrop(SellCrop sellCrop) {
		sellcropRepo.save(sellCrop);
		return "SellCrop Account Created Successfully";
	}
}
