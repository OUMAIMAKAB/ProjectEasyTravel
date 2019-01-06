package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Logement;
import com.ensak.tourismeApp.dao.IBanqueDao;
import com.ensak.tourismeApp.dao.ILogementDao;

public class LogementDaoImpl extends GenericDaoImpl<Logement> implements ILogementDao{

	@Override
	public List<Logement> getVilleLogements(int idVille) {
		Query req=em.createQuery("select a from Logement a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Logement> listLogements = req.getResultList();
		return listLogements;
	}

	@Override
	public Logement getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Logement a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<Logement> listLogements = req.getResultList();
		if(listLogements.size()==0) {
		     return null;	
		}else {
			return listLogements.get(0);
		}
	}

}
