package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Banque;


public interface IBanqueDao extends IGenericDao<Banque>{

public List<Banque> getVilleBanques(int idVille);
	
	public Banque getByIdAndIdVille(int id,int idVille);
}
