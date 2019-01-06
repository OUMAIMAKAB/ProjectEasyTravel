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

import com.ensak.tourismeApp.beans.CentreDeChange;
import com.ensak.tourismeApp.beans.CentreDeChange;
import com.ensak.tourismeApp.service.ICentreDeChangeService;

@RestController
@RequestMapping(value =  "villes/{idVille}/centreDeChanges")
public class CentreDeChangeController {

	@Autowired
	private ICentreDeChangeService centreDeChangeService;
	
	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<CentreDeChange>> getListCentreDeChanges(@PathVariable("idVille") int idVille) {
		
		List <CentreDeChange> centreDeChanges = centreDeChangeService.getVilleCentreDeChanges(idVille);
		if (centreDeChanges.isEmpty()) {
			return new ResponseEntity<List<CentreDeChange>>(HttpStatus.NO_CONTENT);
		}
		
	for(CentreDeChange centreDeChange : centreDeChanges){
			remplirLinks(idVille, centreDeChange);
		}
		return new ResponseEntity<List<CentreDeChange>>(centreDeChanges, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, CentreDeChange centreDeChange) {
		centreDeChange.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/centreDeChanges/"+centreDeChange.getId(), "self");
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CentreDeChange> getCentreDeChange(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

		CentreDeChange centreDeChange = centreDeChangeService.getByIdAndIdVille(idVille, id);
		if (centreDeChange == null) {
			return new ResponseEntity<CentreDeChange>(HttpStatus.NOT_FOUND);
		}
	//	ville.addLink(url, rel);
		
		return new ResponseEntity<CentreDeChange>(centreDeChange, HttpStatus.OK);
	}
	
}
