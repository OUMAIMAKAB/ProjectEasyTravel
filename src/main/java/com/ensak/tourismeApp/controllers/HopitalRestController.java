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

import com.ensak.tourismeApp.beans.Hopital;
import com.ensak.tourismeApp.service.IHopitalService;

@RestController
@RequestMapping(value =  "villes/{idVille}/hopitaux")
public class HopitalRestController {

	@Autowired
	private IHopitalService hopitalService;
	

	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Hopital>> getListHopitals(@PathVariable("idVille") int idVille) {
		
		List <Hopital> hopitaux= hopitalService.getVilleHopitals(idVille);
		if (hopitaux.isEmpty()) {
			return new ResponseEntity<List<Hopital>>(HttpStatus.NO_CONTENT);
		}
		
	for (Hopital hopital : hopitaux) {
			remplirLinks(idVille, hopital);
		}
		return new ResponseEntity<List<Hopital>>(hopitaux, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Hopital hopital) {
		hopital.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/hopitaux/"+hopital.getId(), "self");
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hopital> getHopital(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

		Hopital hopital = hopitalService.getByIdAndIdVille(idVille, id);
		if (hopital == null) {
			return new ResponseEntity<Hopital>(HttpStatus.NOT_FOUND);
		}
	//	ville.addLink(url, rel);
		//remplirLinks(idVille, hopital);
		return new ResponseEntity<Hopital>(hopital, HttpStatus.OK);
	}
	
	
}
