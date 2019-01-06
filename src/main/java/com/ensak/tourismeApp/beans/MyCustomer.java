package com.ensak.tourismeApp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mycustomer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class MyCustomer {

	@Id
	@GeneratedValue
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String city;

	//setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//constructor with fields
	public MyCustomer(int id, String name, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		
		this.email = email;
		this.city = city;
	}
   // constructor without fields
	public MyCustomer() {
		super();
	}
}
