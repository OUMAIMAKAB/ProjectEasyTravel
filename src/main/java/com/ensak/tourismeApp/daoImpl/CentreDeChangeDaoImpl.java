package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.CentreDeChange;
import com.ensak.tourismeApp.dao.IBanqueDao;
import com.ensak.tourismeApp.dao.ICentreDeChangeDao;

public class CentreDeChangeDaoImpl extends GenericDaoImpl<CentreDeChange> implements ICentreDeChangeDao{

	

	@Override
	public List<CentreDeChange> getVilleCentreDeChanges(int idVille) {
		Query req=em.createQuery("select a from CentreDeChange a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<CentreDeChange> listCentreDeChanges = req.getResultList();
		return listCentreDeChanges;
		
	}

	@Override
	public CentreDeChange getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from CentreDeChange a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<CentreDeChange> listCentreDeChanges = req.getResultList();
		if(listCentreDeChanges.size()==0) {
		     return null;	
		}else {
			return listCentreDeChanges.get(0);
		}
	}

	
}
