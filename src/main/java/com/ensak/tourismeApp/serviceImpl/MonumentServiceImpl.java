package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.dao.IMonumentDao;
import com.ensak.tourismeApp.service.IMonumentService;

@Transactional
public class MonumentServiceImpl implements IMonumentService{
	
	@Autowired
	private IMonumentDao dao;

	//setter for customerDao
		public void setDao(IMonumentDao dao) {
			this.dao = dao;
		}

		@Override
		public Monument save(Monument entity) {
			
			return dao.save(entity);
		}

		@Override
		public Monument update(Monument entity) {
			
			return dao.update(entity);
		}

		@Override
		public List<Monument> selectAll() {
			
			return dao.selectAll();
		}

		@Override
		public List<Monument> selectAll(String sortField, String sort) {
			
			return dao.selectAll(sortField, sort);
		}

		@Override
		public Monument getById(int id) {
			
			return dao.getById(id);
		}

		@Override
		public void remove(int id) {
			dao.remove(id);
			
		}

		@Override
		public Monument findOne(String paramName, Object paramValue) {
			
			return dao.findOne(paramName, paramValue);
		}

		@Override
		public Monument findOne(String[] paramNames, Object[] paramValues) {
			
			return dao.findOne(paramNames, paramValues);
		}

		@Override
		public int findCountBy(String paramName, String paramValue) {
			
			return dao.findCountBy(paramName, paramValue);
		}

		@Override
		public List<Monument> getVilleMonuments(int idVille) {
		
			return dao.getVilleMonuments(idVille);
		}

		@Override
		public Monument getByIdAndIdVille(int id, int idVille) {

			return dao.getByIdAndIdVille(id, idVille);
		}

		


}
