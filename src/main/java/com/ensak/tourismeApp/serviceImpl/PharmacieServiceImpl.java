package com.ensak.tourismeApp.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensak.tourismeApp.beans.Pharmacie;
import com.ensak.tourismeApp.dao.IMonumentDao;
import com.ensak.tourismeApp.dao.IPharmacieDao;
import com.ensak.tourismeApp.service.IPharmacieService;

public class PharmacieServiceImpl  implements IPharmacieService{

	@Autowired
	private IPharmacieDao dao;

	//setter for customerDao
		public void setDao(IPharmacieDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Pharmacie save(Pharmacie entity) {
		return dao.save(entity);
	}

	@Override
	public Pharmacie update(Pharmacie entity) {
		return dao.update(entity);
	}

	@Override
	public List<Pharmacie> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Pharmacie> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Pharmacie getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public Pharmacie findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Pharmacie findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Pharmacie> getVillePharmacies(int idVille) {
	
		return dao.getVillePharmacies(idVille);
	}

	@Override
	public Pharmacie getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
