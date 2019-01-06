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

import com.ensak.tourismeApp.beans.Transport;
import com.ensak.tourismeApp.service.IStationService;
import com.ensak.tourismeApp.service.ITransportService;

@RestController
@RequestMapping(value =  "villes/{idVille}/transports")
public class TransportRestController {
	
	@Autowired
	private ITransportService transportService;
	
	@Autowired
	private IStationService stationService;

	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Transport>> getListTransports(@PathVariable("idVille") int idVille) {
		
		List<Transport> transports= transportService.getVilleTransports(idVille);
		if (transports.isEmpty()) {
			return new ResponseEntity<List<Transport>>(HttpStatus.NO_CONTENT);
		}
		
	for (Transport transport : transports) {
			remplirLinks(idVille, transport);
		}
		return new ResponseEntity<List<Transport>>(transports, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Transport transport) {
		transport.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/transports/"+transport.getId(), "self");
	}
	
	       
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Transport> getTransport(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

				Transport transport = transportService.getByIdAndIdVille(idVille, id);
				if (transport == null) {
					return new ResponseEntity<Transport>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
				//remplirLinks(idVille, transport);
				return new ResponseEntity<Transport>(transport, HttpStatus.OK);
			}
			
}
