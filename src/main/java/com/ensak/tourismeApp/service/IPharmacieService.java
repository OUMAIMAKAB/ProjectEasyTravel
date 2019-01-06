package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Pharmacie;

public interface IPharmacieService {

	    public Pharmacie save(Pharmacie entity);
		
		public Pharmacie update(Pharmacie entity);
		
		public List<Pharmacie> selectAll();
		
		public List<Pharmacie> selectAll(String sortField, String sort);
		
		public Pharmacie getById(int id);
		
		public void remove(int id);
		
		public Pharmacie findOne(String paramName, Object paramValue);
		
		public Pharmacie findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		  public List<Pharmacie> getVillePharmacies(int idVille);
			
				public Pharmacie getByIdAndIdVille(int id,int idVille);
}
