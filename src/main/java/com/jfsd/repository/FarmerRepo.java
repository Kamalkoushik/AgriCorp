package com.jfsd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.model.Farmer;

@Repository
public interface FarmerRepo extends CrudRepository<Farmer, Integer>{

	@Query("select f from Farmer f where username=?1 and password=?2")
	public Farmer findByUsernameAndPassword(String username, String password);
	
}
