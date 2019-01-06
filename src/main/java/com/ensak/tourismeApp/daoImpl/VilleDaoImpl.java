package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Ville;
import com.ensak.tourismeApp.dao.IVilleDao;

public class VilleDaoImpl extends GenericDaoImpl<Ville> implements IVilleDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Ville> getVillesTouristiques() {
		Query req=em.createQuery("select a from Ville a where a.isTouristic= 1");
		//req.setParameter("x",1);
		List<Ville> listVillesTouristiques = req.getResultList();
		return listVillesTouristiques;
	}

	@Override
	public List<Ville> getVillesInUnisco() {
		Query req=em.createQuery("select a from Ville a where a.isInUnesco= 1");
		//req.setParameter("x",1);
		List<Ville> listVillesInUnesco = req.getResultList();
		return listVillesInUnesco;
	}

}
