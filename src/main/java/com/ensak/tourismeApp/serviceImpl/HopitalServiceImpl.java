package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensak.tourismeApp.beans.Hopital;
import com.ensak.tourismeApp.dao.IGastronomieDao;
import com.ensak.tourismeApp.dao.IHopitalDao;
import com.ensak.tourismeApp.service.IHopitalService;

public class HopitalServiceImpl implements IHopitalService{

	@Autowired
	private IHopitalDao dao;

	//setter for customerDao
		public void setDao(IHopitalDao dao) {
			this.dao = dao;
		}
		
		
	@Override
	public Hopital save(Hopital entity) {
		return dao.save(entity);
	}

	@Override
	public Hopital update(Hopital entity) {
		return dao.update(entity);
	}

	@Override
	public List<Hopital> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Hopital> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Hopital getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public Hopital findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Hopital findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}


	@Override
	public List<Hopital> getVilleHopitals(int idVille) {
		
		return dao.getVilleHopitals(idVille);
	}


	@Override
	public Hopital getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

	
}
