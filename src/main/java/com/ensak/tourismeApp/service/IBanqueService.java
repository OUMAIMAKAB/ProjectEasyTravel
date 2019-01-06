package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Banque;

public interface IBanqueService {

	    public Banque save(Banque entity);
		
		public Banque update(Banque entity);
		
		public List<Banque> selectAll();
		
		public List<Banque> selectAll(String sortField, String sort);
		
		public Banque getById(int id);
		
		public void remove(int id);
		
		public Banque findOne(String paramName, Object paramValue);
		
		public Banque findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<Banque> getVilleBanques(int idVille);
		
		public Banque getByIdAndIdVille(int id,int idVille);
}
