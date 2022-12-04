package com.jfsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.SellCrop;
import com.jfsd.model.Supplier;
import com.jfsd.repository.SellCropRepo;
import com.jfsd.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService 
{
	@Autowired
	private SupplierRepo repository;
	
	@Autowired
	private SellCropRepo sellcropRepo;

	@Override
	public String addSupplier(Supplier supplier) {
		repository.save(supplier);
		return "Supplier Account Created Successfully";
	}

	@Override
	public Supplier findByUsernameAndPassword(String suname, String spwd) {
		return repository.findByUsernameAndPassword(suname, spwd);
	}

	@Override
	public List<SellCrop> viewallsellcrops() {
		return(List<SellCrop>)sellcropRepo.findAll();
	}

	@Override
	  public Supplier findById(int id) {
	    return repository.findById(id).get();
	  }
	
}
