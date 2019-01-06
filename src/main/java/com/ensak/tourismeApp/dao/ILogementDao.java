package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Logement;
import com.ensak.tourismeApp.beans.Logement;

public interface ILogementDao extends IGenericDao<Logement>{

	 public List<Logement> getVilleLogements(int idVille);
		
		public Logement getByIdAndIdVille(int id,int idVille);
}
