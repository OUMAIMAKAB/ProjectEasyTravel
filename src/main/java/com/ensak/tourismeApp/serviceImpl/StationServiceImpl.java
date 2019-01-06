package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Station;
import com.ensak.tourismeApp.dao.IRestaurantDao;
import com.ensak.tourismeApp.dao.IStationDao;
import com.ensak.tourismeApp.service.IStationService;

@Transactional
public class StationServiceImpl implements IStationService{

	@Autowired
	private IStationDao dao;

	//setter for customerDao
		public void setDao(IStationDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Station save(Station entity) {
		
		return dao.save(entity);
	}

	@Override
	public Station update(Station entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Station> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Station> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Station getById(int id) {
	
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public Station findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Station findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

}
