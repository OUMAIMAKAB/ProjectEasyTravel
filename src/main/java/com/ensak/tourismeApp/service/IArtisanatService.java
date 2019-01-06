package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Monument;



public interface IArtisanatService {

	    public Artisanat save(Artisanat entity);
		
		public Artisanat update(Artisanat entity);
		
		public List<Artisanat> selectAll();
		
		public List<Artisanat> selectAll(String sortField, String sort);
		
		public Artisanat getById(int id);
		
		public void remove(int id);
		
		public Artisanat findOne(String paramName, Object paramValue);
		
		public Artisanat findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<Artisanat> getVilleArtisanats(int idVille);
		
		public Artisanat getByIdAndIdVille(int id,int idVille);
}
