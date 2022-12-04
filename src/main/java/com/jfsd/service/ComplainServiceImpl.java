package com.jfsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Complain;
import com.jfsd.repository.ComplainRepo;

@Service
public class ComplainServiceImpl implements ComplainService{

	@Autowired
	private ComplainRepo complainrepo;
	
	@Override
	public Complain addComplain(Complain complain) {
		return complainrepo.save(complain);
	}

}
