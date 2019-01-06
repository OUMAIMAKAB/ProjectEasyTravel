package com.ensak.tourismeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ensak.tourismeApp.beans.Evaluer;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.service.IEvaluerService;
import com.ensak.tourismeApp.service.IRestaurantService;
import com.ensak.tourismeApp.service.IUtilisateurService;

@RestController
@RequestMapping(value =  "villes/{idVille}/restaurants/{idRestaurant}/evaluer")
public class EvaluerRestController {
	
	@Autowired
	private IEvaluerService evaluerService;
	
	@Autowired
	private IUtilisateurService utilisateurservice;
	
	@Autowired
	private IRestaurantService restaurantservice;

	      
			@RequestMapping(value = "/", method = RequestMethod.GET)
			public ResponseEntity<List<Evaluer>> listAllEvaluer() {
				List<Evaluer> evaluers = evaluerService.selectAll();
				if (evaluers.isEmpty()) {
					return new ResponseEntity<List<Evaluer>>(HttpStatus.NO_CONTENT);
				}
				for (Evaluer evaluer : evaluers) {
					remplirLinks(evaluer);
				}
				return new ResponseEntity<List<Evaluer>>(evaluers, HttpStatus.OK);
			}
			
			private void remplirLinks(Evaluer evaluer) {
		   // evaluer.addLink("http://localhost:8085/tourismeApp/evaluers/"+evaluer.getId(), "self");
			}
			
			
			//
						@RequestMapping(value = "/", method = RequestMethod.POST)
						public ResponseEntity<Evaluer> addEvaluer(@PathVariable("idVille") int idVille,@PathVariable("idRestaurant") int idRestaurant,@RequestBody Evaluer evaluer, UriComponentsBuilder ucb) {
							//if(utilisateurService.getById(utilisatuer.get)) {
							//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
							//} else {
			                    //int idUtilisateur=evaluer.getIdutilisateur();
			                  //  Utilisateur utilisateur=utilisateurservice.getById(idUtilisateur);
			                    
			                  //  Restaurant 
			                    evaluer.setIdRestaurant(idRestaurant);
			                    
								evaluerService.save(evaluer);
								//HttpHeaders headers = new HttpHeaders();
								//headers.setLocation(ucb.path("/utilisateurs/{id}").buildAndExpand(utilisateur.getId()).toUri());
								return new ResponseEntity<Evaluer>(evaluer,HttpStatus.CREATED);
			                    
							}

}
