package com.jfsd.repository;

import org.springframework.data.repository.CrudRepository;
import com.jfsd.model.Contact;

public interface ContactRepo extends CrudRepository<Contact, Integer> {

}
