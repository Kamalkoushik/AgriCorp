package com.jfsd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.model.Supplier;

@Repository
public interface SupplierRepo extends CrudRepository<Supplier, Integer>{

	@Query("select s from Supplier s where username=?1 and password=?2")
	public Supplier findByUsernameAndPassword(String username, String password);

}
