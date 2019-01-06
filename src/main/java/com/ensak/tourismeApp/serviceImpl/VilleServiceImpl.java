package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Ville;
import com.ensak.tourismeApp.dao.IVilleDao;
import com.ensak.tourismeApp.service.IVilleService;

@Transactional
public class VilleServiceImpl implements IVilleService{

	@Autowired
	private IVilleDao dao;

	//setter for customerDao
		public void setDao(IVilleDao dao) {
			this.dao = dao;
		}

		@Override
		public Ville save(Ville entity) {
			
			return dao.save(entity);
		}

		@Override
		public Ville update(Ville entity) {
			
			return dao.update(entity);
		}

		@Override
		public List<Ville> selectAll() {
			
			return dao.selectAll();
		}

		@Override
		public List<Ville> selectAll(String sortField, String sort) {
			
			return dao.selectAll(sortField, sort);
		}

		@Override
		public Ville getById(int id) {
			
			return dao.getById(id);
		}

		@Override
		public void remove(int id) {
			dao.remove(id);
			
		}

		@Override
		public Ville findOne(String paramName, Object paramValue) {
			
			return dao.findOne(paramName, paramValue);
		}

		@Override
		public Ville findOne(String[] paramNames, Object[] paramValues) {
			
			return dao.findOne(paramNames, paramValues);
		}

		@Override
		public int findCountBy(String paramName, String paramValue) {
			
			return dao.findCountBy(paramName, paramValue);
		}

		@Override
		public List<Ville> getVillesTouristiques() {
	
			return dao.getVillesTouristiques();
		}

		@Override
		public List<Ville> getVillesInUnisco() {
		
			return dao.getVillesInUnisco();
		}

}
