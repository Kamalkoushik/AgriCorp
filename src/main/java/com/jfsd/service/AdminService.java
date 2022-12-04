package com.jfsd.service;

import java.util.List;

import com.jfsd.model.Admin;
import com.jfsd.model.Farmer;
import com.jfsd.model.Supplier;

public interface AdminService
{
	public Admin checkadminlogin(String username, String password);
	public List<Farmer> viewallfarmers();
	public List<Supplier> viewallsuppliers();
	public void deletefarmer(int id);
	public void deletesupplier(int id);
}
