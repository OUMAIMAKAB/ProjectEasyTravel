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

import com.ensak.tourismeApp.beans.Logement;
import com.ensak.tourismeApp.service.ILogementService;

@RestController
@RequestMapping(value =  "villes/{idVille}/logements")
public class LogementRestController {

	@Autowired
	private ILogementService logementService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Logement>> getListLogements(@PathVariable("idVille") int idVille) {
		
		List<Logement> logements= logementService.getVilleLogements(idVille);
		if( logements.isEmpty()) {
			return new ResponseEntity<List<Logement>>(HttpStatus.NO_CONTENT);
		}
		
	for (Logement logement : logements) {
			remplirLinks(idVille, logement);
		}
		return new ResponseEntity<List<Logement>>(logements, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Logement logement) {
		logement.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/logements/"+logement.getId(), "self");
	}
	
	       
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Logement> getLogement(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

				Logement logement = logementService.getByIdAndIdVille(idVille, id);
				if (logement == null) {
					return new ResponseEntity<Logement>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
			//	remplirLinks(idVille, logement);
				return new ResponseEntity<Logement>(logement, HttpStatus.OK);
			}
			
	
}
