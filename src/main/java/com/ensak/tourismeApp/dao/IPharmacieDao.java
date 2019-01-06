package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Pharmacie;
import com.ensak.tourismeApp.beans.Pharmacie;

public interface IPharmacieDao extends IGenericDao<Pharmacie>{
	
	  public List<Pharmacie> getVillePharmacies(int idVille);
		
			public Pharmacie getByIdAndIdVille(int id,int idVille);
}
