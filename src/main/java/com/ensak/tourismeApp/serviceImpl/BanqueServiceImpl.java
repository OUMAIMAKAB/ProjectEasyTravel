package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.dao.IArtisanatDao;
import com.ensak.tourismeApp.dao.IBanqueDao;
import com.ensak.tourismeApp.service.IBanqueService;

public class BanqueServiceImpl implements IBanqueService{

	@Autowired
	private IBanqueDao dao;

	//setter for customerDao
			public void setDao(IBanqueDao dao) {
				this.dao = dao;
			}

	@Override
	public Banque save(Banque entity) {
		
		return dao.save(entity);
	}

	@Override
	public Banque update(Banque entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Banque> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Banque> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Banque getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Banque findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Banque findOne(String[] paramNames, Object[] paramValues) {

		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Banque> getVilleBanques(int idVille) {
		
		return dao.getVilleBanques(idVille);
	}

	@Override
	public Banque getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

	
}
