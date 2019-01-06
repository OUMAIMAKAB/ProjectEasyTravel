package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Transport;
import com.ensak.tourismeApp.dao.IRestaurantDao;
import com.ensak.tourismeApp.dao.ITransportDao;
import com.ensak.tourismeApp.service.ITransportService;

@Transactional
public class TransportServiceImpl implements ITransportService{

	@Autowired
	private ITransportDao dao;

	//setter for customerDao
		public void setDao(ITransportDao dao) {
			this.dao = dao;
		}
		
	@Override
	public Transport save(Transport entity) {
	
		return dao.save(entity);
	}

	@Override
	public Transport update(Transport entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Transport> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Transport> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Transport getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Transport findOne(String paramName, Object paramValue) {
	
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Transport findOne(String[] paramNames, Object[] paramValues) {
		
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<Transport> getVilleTransports(int idVille) {
		
		return dao.getVilleTransports(idVille);
	}

	@Override
	public Transport getByIdAndIdVille(int id, int idVille) {
		
		return dao.getByIdAndIdVille(id, idVille);
	}

}
