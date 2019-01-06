package com.ensak.tourismeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensak.tourismeApp.beans.Pharmacie;
import com.ensak.tourismeApp.service.IPharmacieService;

@RestController
@RequestMapping(value =  "villes/{idVille}/pharmacies")
public class PharmacieRestController {
	
	@Autowired
	private IPharmacieService pharmacieService;
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Pharmacie>> test(@PathVariable("idVille") int idVille) {
		
		List<Pharmacie> pharmacies= pharmacieService.getVillePharmacies(idVille);
		if (pharmacies.isEmpty()) {
			return new ResponseEntity<List<Pharmacie>>(HttpStatus.NO_CONTENT);
		}
		
	for (Pharmacie pharmacie : pharmacies) {
			remplirLinks(idVille, pharmacie);
		}
		return new ResponseEntity<List<Pharmacie>>(pharmacies, HttpStatus.OK);
    }

	private void remplirLinks(int idVille, Pharmacie pharmacie) {
		pharmacie.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/pharmacies/"+pharmacie.getId(), "self");
	}
	
	       // Get Single Ville
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Pharmacie> getVille(@PathVariable("idVille") int idVille,@PathVariable("id") int id) {

				Pharmacie pharmacie = pharmacieService.getByIdAndIdVille(id,idVille);
				if (pharmacie == null) {
					return new ResponseEntity<Pharmacie>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
				//remplirLinks(idVille, pharmacie);
				return new ResponseEntity<Pharmacie>(pharmacie, HttpStatus.OK);
			}
	

}
