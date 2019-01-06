package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Hopital;

public interface IHopitalService {

	public Hopital save(Hopital entity);
	
	public Hopital update(Hopital entity);
	
	public List<Hopital> selectAll();
	
	public List<Hopital> selectAll(String sortField, String sort);
	
	public Hopital getById(int id);
	
	public void remove(int id);
	
	public Hopital findOne(String paramName, Object paramValue);
	
	public Hopital findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	 public List<Hopital> getVilleHopitals(int idVille);
		
	public Hopital getByIdAndIdVille(int id,int idVille);
}
