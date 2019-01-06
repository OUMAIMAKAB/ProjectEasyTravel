package com.ensak.tourismeApp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="utilisateur")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp	
public class Utilisateur {

	@Id
    @GeneratedValue
    @Column
	private int id;
	
	@Column
	private String nom;
	
	@Column
	private String image;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Transient 
	public List<Link> links= new ArrayList<Link>();
	
	public void addLink(String url,String rel) {
		
		
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	
	
	
}

