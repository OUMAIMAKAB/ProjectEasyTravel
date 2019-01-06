package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.dao.IArtisanatDao;
import com.ensak.tourismeApp.dao.IMonumentDao;
import com.ensak.tourismeApp.service.IArtisanatService;

@Transactional
public class ArtisanatServiceImpl implements IArtisanatService{

	@Autowired
	private IArtisanatDao dao;

	//setter for customerDao
			public void setDao(IArtisanatDao dao) {
				this.dao = dao;
			}

	
	@Override
	public Artisanat save(Artisanat entity) {
	
		return dao.save(entity);
	}

	@Override
	public Artisanat update(Artisanat entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Artisanat> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Artisanat> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Artisanat getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Artisanat findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Artisanat findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Artisanat> getVilleArtisanats(int idVille) {
		
		return dao.getVilleArtisanats(idVille);
	}


	@Override
	public Artisanat getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
