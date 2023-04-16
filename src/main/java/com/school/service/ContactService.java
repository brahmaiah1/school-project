package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.ContactEntity;
import com.school.pojo.Contact;
import com.school.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;
	
	public void saveContactDetails(Contact contact) {
		ContactEntity entity = convertMapperEntity(contact);
		try {
		contactRepository.save(entity);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	ContactEntity convertMapperEntity(Contact contact) {
		ContactEntity entity =new ContactEntity();
		entity.setCname(contact.getName());
		entity.setCmobilenumber(contact.getMobileNum());
		entity.setCemail(contact.getEmail());
		entity.setSubject(contact.getSubject());
		entity.setMessage(contact.getMessage());
		return entity;
		
	}

}
