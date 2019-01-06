package com.ensak.tourismeApp.daoImpl;


import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.dao.IBanqueDao;

public class BanqueDaoImpl extends GenericDaoImpl<Banque> implements IBanqueDao{

	@Override
	public List<Banque> getVilleBanques(int idVille) {
		Query req=em.createQuery("select a from Banque a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Banque> listBanques = req.getResultList();
		return listBanques;
	}

	@Override
	public Banque getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Banque a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<Banque> listBanques = req.getResultList();
		if(listBanques.size()==0) {
		     return null;	
		}else {
			return listBanques.get(0);
		}
	}

}
