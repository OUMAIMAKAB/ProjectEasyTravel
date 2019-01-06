package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Ville;



public interface IVilleService {

	    public Ville save(Ville entity);
		
		public Ville update(Ville entity);
		
		public List<Ville> selectAll();
		
		public List<Ville> selectAll(String sortField, String sort);
		
		public Ville getById(int id);
		
		public void remove(int id);
		
		public Ville findOne(String paramName, Object paramValue);
		
		public Ville findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<Ville> getVillesTouristiques();
		
		public  List<Ville> getVillesInUnisco();
}
