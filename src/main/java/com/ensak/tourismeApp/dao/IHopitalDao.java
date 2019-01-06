package com.ensak.tourismeApp.dao;


import java.util.List;

import com.ensak.tourismeApp.beans.Hopital;
import com.ensak.tourismeApp.beans.Hopital;

public interface IHopitalDao extends IGenericDao<Hopital>{

	 public List<Hopital> getVilleHopitals(int idVille);
		
		public Hopital getByIdAndIdVille(int id,int idVille);
}
