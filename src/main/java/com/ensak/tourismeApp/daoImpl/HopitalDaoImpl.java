package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Gastronomie;
import com.ensak.tourismeApp.beans.Hopital;
import com.ensak.tourismeApp.dao.IHopitalDao;

public class HopitalDaoImpl extends GenericDaoImpl<Hopital> implements IHopitalDao{

	@Override
	public List<Hopital> getVilleHopitals(int idVille) {
		Query req=em.createQuery("select a from Hopital a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Hopital> listHopitals = req.getResultList();
		return listHopitals;
	}

	@Override
	public Hopital getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Hopital a where a.ville.id= :x and a.id= :y");
		req.setParameter("x",idVille);
		req.setParameter("y", id);
		List<Hopital> listHopitals = req.getResultList();
		if(listHopitals.size()==0)
		return null;
		else 
			return listHopitals.get(0);
	}
	

}
