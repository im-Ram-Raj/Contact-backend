package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Contact;
import com.example.demo.services.IContactService;
import com.example.demo.statusInfo.SuccessInfo;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ContactControllers {

	@Autowired
	IContactService contactService;

//	@Autowired
//	RestTemplate rt;

	// Add contacts in database
	@PostMapping("/contacts")
	public ResponseEntity<SuccessInfo> addContact(@Valid @RequestBody Contact contact) {

		contactService.addContact(contact);
		SuccessInfo successInfo = new SuccessInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				"Contact inserted successfullt!!", contact.getid());
		return new ResponseEntity<>(successInfo, HttpStatus.CREATED);
	}

	// Update Contact in database
	@PutMapping("/contacts/update")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact c) {
		return new ResponseEntity<>(contactService.updateContact(c), HttpStatus.ACCEPTED);
	}

	// Update Favorite of Contact
	@PutMapping("/contacts/fav/{id}")
	public String updateFavourite(@PathVariable("id") int id) {
		return contactService.updateContactFavourite(id);
	}

	// View Contact by id
	@GetMapping("/contacts/view/{id}")
	public Contact getContactById(@PathVariable("id") int cid) {
		return contactService.viewContactById(cid);
	}

	// View All Contacts from database
	@GetMapping("/contacts/viewAll")
	public List<Contact> getAllContacts() {
		StringBuilder sb = new StringBuilder();
		contactService.viewAllContacts().stream().forEach(t -> sb.append(t.toString()));
		return contactService.viewAllContacts();
	}

	// Remove Contact from database
	@DeleteMapping("/contacts/delete/{ContactId}")
	public ResponseEntity<String> deleteContact(@PathVariable("ContactId") int cid) {
		contactService.removeContact(cid);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}

}