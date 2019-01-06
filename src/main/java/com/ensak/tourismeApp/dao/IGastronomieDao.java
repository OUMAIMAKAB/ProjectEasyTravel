package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Gastronomie;

public interface IGastronomieDao extends IGenericDao<Gastronomie>{
	
	    public List<Gastronomie> getVilleGastronomies(int idVille);
		
		public Gastronomie getByIdAndIdVille(int id,int idVille);

}
