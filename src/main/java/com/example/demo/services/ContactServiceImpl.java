package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IContactDao;
import com.example.demo.entity.Contact;

@Service("contact")
public class ContactServiceImpl implements IContactService {

	@Autowired
	IContactDao contact;
	
	@Override
	public Contact addContact(Contact add) {
		// TODO Auto-generated method stub
		return contact.save(add);
	}

	@Override
	public Contact updateContact(Contact update) {
		// TODO Auto-generated method stub
		return contact.save(update);
	}

	@Override
	public void removeContact(int id) {
		if(contact.existsById(id))
			contact.deleteById(id);
	}

	@Override
	public List<Contact> viewAllContacts() {
		// TODO Auto-generated method stub
		return contact.findAll();
	}

	@Override
	public Contact viewContactById(int id) {
		// TODO Auto-generated method stub
		Optional<Contact> c = contact.findById(id);
		if(c.isPresent())
			return c.get();
		else
			return null;
	}

	@Override
	public String updateContactFavourite(int id) {
		// TODO Auto-generated method stub
		Contact c = contact.getById(id);
		if(c.isFav()) {
			c.setFav(false);
			contact.save(c);
			return "Favourite changed success";
		}
		else {
			c.setFav(true);
			contact.save(c);
		}
		return null;
	}

}
