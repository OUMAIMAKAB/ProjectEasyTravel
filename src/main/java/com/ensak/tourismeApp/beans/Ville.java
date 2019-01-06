package com.ensak.tourismeApp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ville")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class Ville {
	
	
	@Id
	@Column 
	private int id;
	
	@Column
	public String name;
	
	@Column
	public String image;
	
	

	@Column
	@JsonIgnore
	public Boolean isTouristic;
	
	@Column
	@JsonIgnore
	public Boolean isInUnesco;
	
	@Column
	public double longitude;
	
	@Column
	public double latitude;
	
	@Transient 
	public List<Link> links=new ArrayList<Link>();
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getIsTouristic() {
		return isTouristic;
	}

	public void setIsTouristic(Boolean isTouristic) {
		this.isTouristic = isTouristic;
	}

	public Boolean getIsInUnesco() {
		return isInUnesco;
	}

	public void setIsInUnesco(Boolean isInUnesco) {
		this.isInUnesco = isInUnesco;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void addLink(String url,String rel) {
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	
	// lien_vers_la_Ville //Monuments //Restaurants //Transport //Artisant //Banque //CentreDeChange //Gastronomie //Hopital //Logement //Pharmacie => LINK vers ça
	
	
	
	
	
	
}
