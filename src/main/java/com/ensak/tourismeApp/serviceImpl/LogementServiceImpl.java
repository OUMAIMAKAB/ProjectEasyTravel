package com.ensak.tourismeApp.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Logement;
import com.ensak.tourismeApp.dao.ILogementDao;
import com.ensak.tourismeApp.service.ILogementService;

@Transactional
public class LogementServiceImpl implements ILogementService{

	@Autowired
	private ILogementDao dao;

	//setter for customerDao
		public void setDao(ILogementDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Logement save(Logement entity) {
		
		return dao.save(entity);
	}

	@Override
	public Logement update(Logement entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Logement> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Logement> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Logement getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Logement findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Logement findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Logement> getVilleLogements(int idVille) {
		
		return dao.getVilleLogements(idVille);
	}

	@Override
	public Logement getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
