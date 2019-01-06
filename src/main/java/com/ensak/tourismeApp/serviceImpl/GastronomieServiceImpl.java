package com.ensak.tourismeApp.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensak.tourismeApp.beans.Gastronomie;
import com.ensak.tourismeApp.dao.ICustomerDao;
import com.ensak.tourismeApp.dao.IGastronomieDao;
import com.ensak.tourismeApp.service.IGastronomieService;

public class GastronomieServiceImpl implements IGastronomieService{

	@Autowired
	private IGastronomieDao dao;

	//setter for customerDao
		public void setDao(IGastronomieDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Gastronomie save(Gastronomie entity) {
		
		return dao.save(entity);
	}

	@Override
	public Gastronomie update(Gastronomie entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Gastronomie> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Gastronomie> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Gastronomie getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Gastronomie findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Gastronomie findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Gastronomie> getVilleGastronomies(int idVille) {
		
		return dao.getVilleGastronomies(idVille);
	}

	@Override
	public Gastronomie getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
