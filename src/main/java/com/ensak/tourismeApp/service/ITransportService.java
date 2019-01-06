package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Transport;

public interface ITransportService {

public Transport save(Transport entity);
	
	public Transport update(Transport entity);
	
	public List<Transport> selectAll();
	
	public List<Transport> selectAll(String sortField, String sort);
	
	public Transport getById(int id);
	
	public void remove(int id);
	
	public Transport findOne(String paramName, Object paramValue);
	
	public Transport findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	 public List<Transport> getVilleTransports(int idVille);
		
	public Transport getByIdAndIdVille(int id,int idVille);
}
