package com.jfsd.service;

import java.util.List;

import com.jfsd.model.SellCrop;
import com.jfsd.model.Supplier;

public interface SupplierService 
{
	public String addSupplier(Supplier supplier);
	public Supplier findByUsernameAndPassword(String suname, String spwd);
	public List<SellCrop> viewallsellcrops();
	public Supplier findById(int id) ;
}
