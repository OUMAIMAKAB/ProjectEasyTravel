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
import com.ensak.tourismeApp.beans.Banque;

import com.ensak.tourismeApp.service.IBanqueService;

@RestController
@RequestMapping(value =  "villes/{idVille}/banques")
public class BanqueRestController {


	@Autowired
	private IBanqueService banqueService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Banque>> getListBanques(@PathVariable("idVille") int idVille) {
		
		List <Banque> banques= banqueService.getVilleBanques(idVille);
		if (banques.isEmpty()) {
			return new ResponseEntity<List<Banque>>(HttpStatus.NO_CONTENT);
		}
		
	for (Banque banque : banques) {
			remplirLinks(idVille, banque);
		}
		return new ResponseEntity<List<Banque>>(banques, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Banque banque) {
		banque.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/banques/"+banque.getId(), "self");
	}
	
	       
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Banque> getBanque(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

				Banque banque = banqueService.getByIdAndIdVille(idVille, id);
				if (banque == null) {
					return new ResponseEntity<Banque>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
				remplirLinks(idVille, banque);
				return new ResponseEntity<Banque>(banque, HttpStatus.OK);
			}
			
			
}
