package com.jfsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.model.Contact;
import com.jfsd.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepo contactrepo;

	@Override
	public Contact addcontact(Contact contact) {
		return contactrepo.save(contact);
	} 
	
	
	
}
