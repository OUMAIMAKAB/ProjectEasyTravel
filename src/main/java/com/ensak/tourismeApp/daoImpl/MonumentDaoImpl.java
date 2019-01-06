package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.beans.Ville;
import com.ensak.tourismeApp.dao.IMonumentDao;

public class MonumentDaoImpl extends GenericDaoImpl<Monument> implements IMonumentDao{

	@Override
	public List<Monument> getVilleMonuments(int idVille) {
		Query req=em.createQuery("select a from Monument a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Monument> listMonuments = req.getResultList();
		return listMonuments;
	}

	@Override
	public Monument getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Monument a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<Monument> listMonuments = req.getResultList();
		if(listMonuments.size()==0) {
		     return null;	
		}else {
			return listMonuments.get(0);
		}
		
	}

	
}
