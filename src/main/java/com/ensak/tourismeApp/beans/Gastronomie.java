package com.ensak.tourismeApp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="gastronomie")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class Gastronomie {
	
	@Id
    @GeneratedValue
    @Column
	private int id;
    
	@Column
	private String nom;
	
	@Column
	private String description;
	
	@Column
	private String image;
	
	@ManyToOne
	@JoinColumn(name="idVille")
	@JsonIgnore
	private Ville ville;

	@Transient 
	public List<Link> links=new ArrayList<Link>();
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public void addLink(String url,String rel) {
		
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
	
}
