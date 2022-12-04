package com.jfsd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.model.Tips;

@Repository
public interface TipsRepo extends CrudRepository<Tips, Integer>{

}