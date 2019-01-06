package com.ensak.tourismeApp.controllers;

import java.util.List;

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

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.service.IUtilisateurService;

@RestController
@RequestMapping(value =  "utilisateurs")
public class UtilisateurRestController {
	
	@Autowired
	private IUtilisateurService utilisateurService;

	       // Get All Utilisateurs
			@RequestMapping(value = "/", method = RequestMethod.GET)
			public ResponseEntity<List<Utilisateur>> listAllUtilisateurs() {
				List<Utilisateur> utilisateurs = utilisateurService.selectAll();
				if (utilisateurs.isEmpty()) {
					return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
				}
				for (Utilisateur utilisateur : utilisateurs) {
					remplirLinks(utilisateur);
				}
				return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
			}
			
			private void remplirLinks(Utilisateur utilisateur) {
				utilisateur.addLink("http://localhost:8085/tourismeApp/utilisateurs/"+utilisateur.getId(), "self");
			}
			
			
			// Add Utilisateur
			@RequestMapping(value = "/", method = RequestMethod.POST)
			public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur, UriComponentsBuilder ucb) {
				//if(utilisateurService.getById(utilisatuer.get)) {
				//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				//} else {
                    
					utilisateurService.save(utilisateur);
					HttpHeaders headers = new HttpHeaders();
					headers.setLocation(ucb.path("/utilisateurs/{id}").buildAndExpand(utilisateur.getId()).toUri());
					return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.CREATED);
                    
				}
			
			
			// Get Single Utilisateur
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("id") int id) {

				Utilisateur utilisateur = utilisateurService.getById(id);
				if (utilisateur == null) {
					return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
			}
			
			// Update Utilisateur
			@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
			public ResponseEntity<Utilisateur> updateCustomer(@PathVariable("id") int id, @RequestBody Utilisateur cus) {

				Utilisateur utilisateur = utilisateurService.getById(id);

				if (utilisateur == null) {
					return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
				}

				utilisateur.setNom(cus.getNom());
				//utilisateur.setImage(image);
				utilisateur.setEmail(cus.getEmail());
				utilisateur.setPassword(cus.getPassword());

				utilisateurService.update(utilisateur);
				return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
			}
			
			// Delete Utilisateur
			@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
			public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable("id") int id) {

				Utilisateur utilisateur = utilisateurService.getById(id);
				if (utilisateur == null) {
					return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
				}

				utilisateurService.remove(id);
				return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
			}
			
			
			@RequestMapping(value = "/connection", method = RequestMethod.POST)
			public ResponseEntity<Utilisateur> addUtilisateurConnecte(@RequestBody Utilisateur utilisateur, UriComponentsBuilder ucb) {
				//if(utilisateurService.getById(utilisatuer.get)) {
				//	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				//} else {
                    
				Utilisateur	utilisateur1 = utilisateurService.getByIdAndIdUtilisateur(utilisateur.getNom(), utilisateur.getPassword());
				return new ResponseEntity<Utilisateur>(utilisateur1,HttpStatus.CREATED);
                    
				}
			
			
}
