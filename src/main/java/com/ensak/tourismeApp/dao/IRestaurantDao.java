package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Restaurant;

public interface IRestaurantDao extends IGenericDao<Restaurant>{

	 public List<Restaurant> getVilleRestaurants(int idVille);
		
		public Restaurant getByIdAndIdVille(int id,int idVille);
}
