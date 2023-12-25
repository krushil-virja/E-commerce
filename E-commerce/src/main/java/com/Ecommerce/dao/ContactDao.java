package com.Ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repository.ContactRepository;
import com.Ecommerce.entities.Contact;

@Service
public class ContactDao {
    
	@Autowired
	private ContactRepository contactRepository;
	
	
	public Contact addContact(Contact contact) {
		
		Contact save = contactRepository.save(contact);
		return save;
		
	}
	
	
	
	public List<Contact> showAllContact(){
		
		List<Contact> showContacts = contactRepository.findAll();
		
		return showContacts;
	}
	
}
