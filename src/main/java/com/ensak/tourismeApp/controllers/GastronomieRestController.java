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

import com.ensak.tourismeApp.beans.Gastronomie;
import com.ensak.tourismeApp.service.IGastronomieService;

@RestController
@RequestMapping(value =  "villes/{idVille}/gastronomies")
public class GastronomieRestController {

	@Autowired
	private IGastronomieService gastronomieService;
	
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Gastronomie>> getListGastronomies(@PathVariable("idVille") int idVille) {
		
		List <Gastronomie> gastronomies= gastronomieService.getVilleGastronomies(idVille);
		if (gastronomies.isEmpty()) {
			return new ResponseEntity<List<Gastronomie>>(HttpStatus.NO_CONTENT);
		}
		
	for (Gastronomie gastronomie : gastronomies) {
			remplirLinks(idVille, gastronomie);
		}
		return new ResponseEntity<List<Gastronomie>>(gastronomies, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Gastronomie gastronomie) {
		gastronomie.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/gastronomies/"+gastronomie.getId(), "self");
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gastronomie> getGastronomie(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

		Gastronomie gastronomie = gastronomieService.getByIdAndIdVille(idVille, id);
		if (gastronomie == null) {
			return new ResponseEntity<Gastronomie>(HttpStatus.NOT_FOUND);
		}
	//	ville.addLink(url, rel);
		//remplirLinks(idVille, gastronomie);
		return new ResponseEntity<Gastronomie>(gastronomie, HttpStatus.OK);
	}
	
}
