package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Gastronomie;

public interface IGastronomieService {

	 public Gastronomie save(Gastronomie entity);
		
		public Gastronomie update(Gastronomie entity);
		
		public List<Gastronomie> selectAll();
		
		public List<Gastronomie> selectAll(String sortField, String sort);
		
		public Gastronomie getById(int id);
		
		public void remove(int id);
		
		public Gastronomie findOne(String paramName, Object paramValue);
		
		public Gastronomie findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<Gastronomie> getVilleGastronomies(int idVille);
		
		public Gastronomie getByIdAndIdVille(int id,int idVille);
}
