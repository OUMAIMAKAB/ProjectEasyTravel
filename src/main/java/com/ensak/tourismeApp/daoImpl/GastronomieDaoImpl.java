package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Gastronomie;
import com.ensak.tourismeApp.beans.MyCustomer;
import com.ensak.tourismeApp.dao.IGastronomieDao;


public class GastronomieDaoImpl extends GenericDaoImpl<Gastronomie> implements IGastronomieDao{

	@Override
	public List<Gastronomie> getVilleGastronomies(int idVille) {
		Query req=em.createQuery("select a from Gastronomie a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Gastronomie> listGastronimies = req.getResultList();
		return listGastronimies;
	}

	@Override
	public Gastronomie getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Gastronomie a where a.ville.id= :x and a.id= :y");
		req.setParameter("x",idVille);
		req.setParameter("y", id);
		List<Gastronomie> listGastronomies = req.getResultList();
		if(listGastronomies.size()==0)
		return null;
		else 
			return listGastronomies.get(0);
	}

}
