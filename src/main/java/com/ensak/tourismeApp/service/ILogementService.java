package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Logement;

public interface ILogementService {

public Logement save(Logement entity);
	
	public Logement update(Logement entity);
	
	public List<Logement> selectAll();
	
	public List<Logement> selectAll(String sortField, String sort);
	
	public Logement getById(int id);
	
	public void remove(int id);
	
	public Logement findOne(String paramName, Object paramValue);
	
	public Logement findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	 public List<Logement> getVilleLogements(int idVille);
		
	public Logement getByIdAndIdVille(int id,int idVille);
}
