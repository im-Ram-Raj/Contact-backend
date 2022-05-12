package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Name is required!")
	private String name;
	@NotEmpty(message = "Email is required!")
	private String email;
	@NotEmpty(message = "Phone Number is required!")
	private String phone;
	@NotEmpty(message = "Favourite is required!")
	private boolean fav;

	public Contact() {
		super();
	}

	public Contact(int id, @NotEmpty(message = "Name is required!") String name,
			@NotEmpty(message = "Email is required!") String email,
			@NotEmpty(message = "Phone Number is required!") String phone,
			@NotEmpty(message = "Favourite is required!") boolean fav) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.fav = fav;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public boolean isFav() {
		return fav;
	}

	public void setFav(boolean fav) {
		this.fav = fav;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", fav=" + fav + "]";
	}

	

}
