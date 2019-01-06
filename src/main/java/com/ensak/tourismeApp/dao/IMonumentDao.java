package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Monument;

public interface IMonumentDao extends IGenericDao<Monument>{

	public List<Monument> getVilleMonuments(int idVille);
	
	public Monument getByIdAndIdVille(int id,int idVille);
}
