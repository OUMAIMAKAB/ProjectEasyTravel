package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Restaurant;

public interface IRestaurantService {
	
public Restaurant save(Restaurant entity);
	
	public Restaurant update(Restaurant entity);
	
	public List<Restaurant> selectAll();
	
	public List<Restaurant> selectAll(String sortField, String sort);
	
	public Restaurant getById(int id);
	
	public void remove(int id);
	
	public Restaurant findOne(String paramName, Object paramValue);
	
	public Restaurant findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	 public List<Restaurant> getVilleRestaurants(int idVille);
		
	public Restaurant getByIdAndIdVille(int id,int idVille);

}
