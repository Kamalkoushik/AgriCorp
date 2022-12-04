package com.jfsd.repository;

import org.springframework.data.repository.CrudRepository;

import com.jfsd.model.Crop;

public interface CropRepo extends CrudRepository<Crop, Integer>{

}
