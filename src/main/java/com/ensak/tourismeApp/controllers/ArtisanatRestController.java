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

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.service.IArtisanatService;

@RestController
@RequestMapping(value =  "villes/{idVille}/artisanats")
public class ArtisanatRestController {

	@Autowired
	private IArtisanatService artisanatService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Artisanat>> getListArtisanats(@PathVariable("idVille") int idVille) {
		
		List<Artisanat> artisanats= artisanatService.getVilleArtisanats(idVille);
		if (artisanats.isEmpty()) {
			return new ResponseEntity<List<Artisanat>>(HttpStatus.NO_CONTENT);
		}
		
	for (Artisanat artisanat : artisanats) {
			remplirLinks(idVille, artisanat);
		}
		return new ResponseEntity<List<Artisanat>>(artisanats, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Artisanat artisanat) {
		artisanat.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/artisanats/"+artisanat.getId(), "self");
	}
	
	       
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Artisanat> getArtisanat(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

				Artisanat artisanat = artisanatService.getByIdAndIdVille(idVille, id);
				if (artisanat == null) {
					return new ResponseEntity<Artisanat>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
				
				return new ResponseEntity<Artisanat>(artisanat, HttpStatus.OK);
			}
			
			
	
}
