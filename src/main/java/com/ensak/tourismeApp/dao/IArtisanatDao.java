package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Monument;



public interface IArtisanatDao extends IGenericDao<Artisanat>{
	
    public List<Artisanat> getVilleArtisanats(int idVille);
	
	public Artisanat getByIdAndIdVille(int id,int idVille);
}
