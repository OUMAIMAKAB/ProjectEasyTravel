package com.ensak.tourismeApp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ensak.tourismeApp.beans.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="transport")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class Transport {
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column
	private String type;
	
	@ManyToOne
	@JoinColumn(name="idVille")
	@JsonIgnore
	private Ville ville;
	
	@Column
	private String prix;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Station> stations;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	
}
