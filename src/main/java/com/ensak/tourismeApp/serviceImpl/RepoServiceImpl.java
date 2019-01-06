package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Repo;
import com.ensak.tourismeApp.dao.IRepoDao;
import com.ensak.tourismeApp.dao.IVilleDao;
import com.ensak.tourismeApp.service.IRepoService;

@Transactional
public class RepoServiceImpl implements IRepoService{

	
	@Autowired
	private IRepoDao dao;

	//setter for customerDao
		public void setDao(IRepoDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Repo save(Repo entity) {
		
		return dao.save(entity);
	}

	@Override
	public Repo update(Repo entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Repo> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Repo> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Repo getById(int id) {
	
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Repo findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Repo findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

}
