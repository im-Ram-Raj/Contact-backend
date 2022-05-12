package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Contact;

public interface IContactService {

	public Contact addContact(Contact add);

	public Contact updateContact(Contact update);

	public void removeContact(int id);

	public List<Contact> viewAllContacts();

	public Contact viewContactById(int id);
	
	public String updateContactFavourite(int id);

}
