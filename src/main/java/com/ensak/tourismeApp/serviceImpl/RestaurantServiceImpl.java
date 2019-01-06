package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Restaurant;
import com.ensak.tourismeApp.dao.IHopitalDao;
import com.ensak.tourismeApp.dao.IRestaurantDao;
import com.ensak.tourismeApp.service.IRestaurantService;

@Transactional
public class RestaurantServiceImpl implements IRestaurantService{
	

	@Autowired
	private IRestaurantDao dao;

	//setter for customerDao
		public void setDao(IRestaurantDao dao) {
			this.dao = dao;
		}

		@Override
		public Restaurant save(Restaurant entity) {
			
			return dao.save(entity);
		}

		@Override
		public Restaurant update(Restaurant entity) {
			
			return dao.update(entity);
		}

		@Override
		public List<Restaurant> selectAll() {
			
			return dao.selectAll();
		}

		@Override
		public List<Restaurant> selectAll(String sortField, String sort) {
			
			return dao.selectAll(sortField, sort);
		}

		@Override
		public Restaurant getById(int id) {
			
			return dao.getById(id);
		}

		@Override
		public void remove(int id) {
               dao.remove(id);			
		}

		@Override
		public Restaurant findOne(String paramName, Object paramValue) {
			
			return dao.findOne(paramName, paramValue);
		}

		@Override
		public Restaurant findOne(String[] paramNames, Object[] paramValues) {
			
			return dao.findOne(paramNames, paramValues);
		}

		@Override
		public int findCountBy(String paramName, String paramValue) {
			
			return dao.findCountBy(paramName, paramValue);
		}

		@Override
		public List<Restaurant> getVilleRestaurants(int idVille) {
			
			return dao.getVilleRestaurants(idVille);
		}

		@Override
		public Restaurant getByIdAndIdVille(int id, int idVille) {
			
			return dao.getByIdAndIdVille(id, idVille);
		}
		
}

