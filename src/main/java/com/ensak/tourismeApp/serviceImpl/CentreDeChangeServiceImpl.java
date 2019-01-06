package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensak.tourismeApp.beans.CentreDeChange;
import com.ensak.tourismeApp.dao.ICentreDeChangeDao;
import com.ensak.tourismeApp.dao.ICustomerDao;
import com.ensak.tourismeApp.service.IBanqueService;
import com.ensak.tourismeApp.service.ICentreDeChangeService;

public class CentreDeChangeServiceImpl implements ICentreDeChangeService{

	@Autowired
	private ICentreDeChangeDao dao;

	//setter for customerDao
		public void setDao(ICentreDeChangeDao dao) {
			this.dao = dao;
		}
		
	@Override
	public CentreDeChange save(CentreDeChange entity) {
		
		return dao.save(entity);
	}

	@Override
	public CentreDeChange update(CentreDeChange entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<CentreDeChange> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<CentreDeChange> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CentreDeChange getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public CentreDeChange findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CentreDeChange findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<CentreDeChange> getVilleCentreDeChanges(int idVille) {
		
		return dao.getVilleCentreDeChanges(idVille);
	}

	@Override
	public CentreDeChange getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
