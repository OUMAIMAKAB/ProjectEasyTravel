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

import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.beans.Ville;
import com.ensak.tourismeApp.service.IMonumentService;
import com.ensak.tourismeApp.service.IVilleService;

@RestController
@RequestMapping(value =  "villes/{idVille}/monuments")
public class MonumentRestController {

	@Autowired
	private IMonumentService monumentService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Monument>> test(@PathVariable("idVille") int idVille) {
		
		List<Monument> monuments= monumentService.getVilleMonuments(idVille);
		if (monuments.isEmpty()) {
			return new ResponseEntity<List<Monument>>(HttpStatus.NO_CONTENT);
		}
		
	for (Monument monument : monuments) {
			remplirLinks(idVille, monument);
		}
		return new ResponseEntity<List<Monument>>(monuments, HttpStatus.OK);
    }

	private void remplirLinks(int idVille, Monument monument) {
		monument.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/monuments/"+monument.getId(), "self");
	}
	
	       // Get Single Ville
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Monument> getVille(@PathVariable("idVille") int idVille,@PathVariable("id") int id) {

				Monument monument = monumentService.getByIdAndIdVille(id,idVille);
				if (monument == null) {
					return new ResponseEntity<Monument>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
			//	remplirLinks(idVille, monument);
				return new ResponseEntity<Monument>(monument, HttpStatus.OK);
			}
	
	
}
