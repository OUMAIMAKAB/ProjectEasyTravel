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

import com.ensak.tourismeApp.beans.Restaurant;
import com.ensak.tourismeApp.service.IRestaurantService;

@RestController
@RequestMapping(value =  "villes/{idVille}/restaurants")
public class RestaurantRestController {
	
	@Autowired
	private IRestaurantService restaurantService;

	@RequestMapping(value =  "/",method = RequestMethod.GET)
    public ResponseEntity<List<Restaurant>> getListRestaurants(@PathVariable("idVille") int idVille) {
		
		List<Restaurant> restaurants= restaurantService.getVilleRestaurants(idVille);
		if (restaurants.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NO_CONTENT);
		}
		
	for (Restaurant restaurant : restaurants) {
			remplirLinks(idVille, restaurant);
		}
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }


	private void remplirLinks(int idVille, Restaurant restaurant) {
		restaurant.addLink("http://localhost:8085/tourismeApp/villes/"+idVille+"/restaurants/"+restaurant.getId(), "self");
	}
	
	       
			@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") int id,@PathVariable("idVille") int idVille) {

				Restaurant restaurant = restaurantService.getByIdAndIdVille(idVille, id);
				if (restaurant == null) {
					return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
				}
			//	ville.addLink(url, rel);
			//	remplirLinks(idVille, restaurant);
				return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
			}
			
}
