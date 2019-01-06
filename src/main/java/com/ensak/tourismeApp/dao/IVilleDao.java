package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Ville;

public interface IVilleDao extends IGenericDao<Ville>{

	public  List<Ville> getVillesTouristiques();
	public  List<Ville> getVillesInUnisco();
}
