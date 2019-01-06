package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Pharmacie;
import com.ensak.tourismeApp.beans.Pharmacie;
import com.ensak.tourismeApp.dao.IPharmacieDao;

public class PharmacieDaoImpl extends GenericDaoImpl<Pharmacie> implements IPharmacieDao{

	@Override
	public List<Pharmacie> getVillePharmacies(int idVille) {
		Query req=em.createQuery("select a from Pharmacie a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Pharmacie> listPharmacies = req.getResultList();
		return listPharmacies;
	}

	@Override
	public Pharmacie getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Pharmacie a where a.ville.id= :x and a.id= :y");
		req.setParameter("x",idVille);
		req.setParameter("y", id);
		List<Pharmacie> listPharmacies = req.getResultList();
		if(listPharmacies.size()==0)
		return null;
		else 
			return listPharmacies.get(0);
	}

}
