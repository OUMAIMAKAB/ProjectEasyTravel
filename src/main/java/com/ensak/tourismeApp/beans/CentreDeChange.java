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
@Table(name="centredechange")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class CentreDeChange {
	
	
	    @Id
	    @GeneratedValue
	    @Column
	    private int id;
		
	    @Column
		private String name;
		
	    @Column
		private double longitude;
	    
		@Column
		private double latitude;
		
		
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
