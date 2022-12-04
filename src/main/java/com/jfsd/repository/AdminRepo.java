package com.jfsd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, String>
{
	@Query("select a from Admin a where username=?1 and password=?2")
	public Admin checkadminlogin(String uname,String pwd);
}
