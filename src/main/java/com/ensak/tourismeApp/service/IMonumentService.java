package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Monument;

public interface IMonumentService {

	  public Monument save(Monument entity);
		
			public Monument update(Monument entity);
			
			public List<Monument> selectAll();
			
			public List<Monument> selectAll(String sortField, String sort);
			
			public Monument getById(int id);
			
			public void remove(int id);
			
			public Monument findOne(String paramName, Object paramValue);
			
			public Monument findOne(String[] paramNames, Object[] paramValues);
			
			public int findCountBy(String paramName, String paramValue);
			
			public List<Monument> getVilleMonuments(int idVille);
			
			public Monument getByIdAndIdVille(int id,int idVille);
}
