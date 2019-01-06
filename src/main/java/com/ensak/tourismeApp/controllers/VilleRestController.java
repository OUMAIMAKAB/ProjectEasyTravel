package com.ensak.tourismeApp.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ensak.tourismeApp.beans.MyCustomer;
import com.ensak.tourismeApp.beans.Ville;
import com.ensak.tourismeApp.service.CustomerService;
import com.ensak.tourismeApp.service.IVilleService;


@RestController
@RequestMapping("villes")
public class VilleRestController {
	
	@Autowired
	private IVilleService villeService;
	
	@Autowired
	ServletContext servletContext;
	
	
	  //setter for IVilleService
		public void setCustomerService(IVilleService villeService) {
			this.villeService = villeService;
		}
		
		// Get All Villes
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ResponseEntity<List<Ville>> listAllVilles() {
			
			List<Ville> villes = villeService.selectAll();
			if (villes.isEmpty()) {
				return new ResponseEntity<List<Ville>>(HttpStatus.NO_CONTENT);
			}
			for (Ville ville : villes) {
				remplirLinks(ville);
			}
			return new ResponseEntity<List<Ville>>(villes, HttpStatus.OK);
		}

		private void remplirLinks(Ville ville) {
			//self
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId(), "self");
			//monuments
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/monuments/", "monuments");
			//artisanats
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/artisanats/", "artisanats");
			//banque
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/banques/", "banques");
			//CentreDeChange
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/centreDeChanges/", "centreDeChanges");
			//Gastronomie
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/gastronomies/", "gastronomies");
			//Hopital
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/hopitaux/", "hopitaux");
			//Logement
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/logements/", "logements");
			//Pharmacie
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/pharmacies/", "pharmacies");
			//Restaurant
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/restaurants/", "restaurants");
			//transport
			ville.addLink("http://localhost:8085/tourismeApp/villes/"+ville.getId()+"/transports/", "transports");
			
		}
		
		
		
		// Get Single Ville
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Ville> getVille(@PathVariable("id") int id) {

			Ville ville = villeService.getById(id);
			if (ville == null) {
				return new ResponseEntity<Ville>(HttpStatus.NOT_FOUND);
			}
		//	ville.addLink(url, rel);
			
			return new ResponseEntity<Ville>(ville, HttpStatus.OK);
		}
		
		
		//Get Villes Touristiques
		@RequestMapping(value = "/villesTouristiques", method = RequestMethod.GET)
		public ResponseEntity<List<Ville>> listVillesTouristiques() {
			List<Ville> villes = villeService.getVillesTouristiques();
			if (villes.isEmpty()) {
				return new ResponseEntity<List<Ville>>(HttpStatus.NO_CONTENT);
			}
			for (Ville ville : villes) {
				
			}
			return new ResponseEntity<List<Ville>>(villes, HttpStatus.OK);
		}
		
		//Get Villes In Unesco
				@RequestMapping(value = "/villesInUnesco", method = RequestMethod.GET)
				public ResponseEntity<List<Ville>> listVillesUnesco() {
					List<Ville> villes = villeService.getVillesInUnisco();
					if (villes.isEmpty()) {
						return new ResponseEntity<List<Ville>>(HttpStatus.NO_CONTENT);
					}
					for (Ville ville : villes) {
						
					}
					return new ResponseEntity<List<Ville>>(villes, HttpStatus.OK);
				}
			
				
		

		
		

}
