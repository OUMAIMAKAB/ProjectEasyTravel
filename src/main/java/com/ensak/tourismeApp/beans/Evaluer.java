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
@Table(name="evaluer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evaluer {
	
	@Id
    @GeneratedValue
    @Column
	private int id;
	
	@Column
    private int idutilisateur;
	
	@Column
	private String commentaire;
	
	@Column
	private int idRestaurant;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	
	public int getIdUtilisateur() {
		return idutilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idutilisateur = idUtilisateur;
	}
	
	

	@Transient 
	public List<Link> links= new ArrayList<Link>();
	
	public void addLink(String url,String rel) {
		
		
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}






	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}


}
