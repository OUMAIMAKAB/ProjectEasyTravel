package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Restaurant;
import com.ensak.tourismeApp.dao.IBanqueDao;
import com.ensak.tourismeApp.dao.IRestaurantDao;

public class RestaurantDaoImpl extends GenericDaoImpl<Restaurant> implements IRestaurantDao{

	@Override
	public List<Restaurant> getVilleRestaurants(int idVille) {
		Query req=em.createQuery("select a from Restaurant a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Restaurant> listRestaurants = req.getResultList();
		return listRestaurants;
	}

	@Override
	public Restaurant getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Restaurant a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<Restaurant> listRestaurants = req.getResultList();
		if(listRestaurants.size()==0) {
		     return null;	
		}else {
			return listRestaurants.get(0);
		}
	}
	
	

}
