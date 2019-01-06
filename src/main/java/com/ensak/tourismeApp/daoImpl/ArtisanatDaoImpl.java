package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Artisanat;
import com.ensak.tourismeApp.beans.Monument;
import com.ensak.tourismeApp.beans.MyCustomer;
import com.ensak.tourismeApp.dao.IArtisanatDao;
import com.ensak.tourismeApp.dao.ICustomerDao;

public class ArtisanatDaoImpl extends GenericDaoImpl<Artisanat> implements IArtisanatDao{

	@Override
	public List<Artisanat> getVilleArtisanats(int idVille) {
		Query req=em.createQuery("select a from Artisanat a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Artisanat> listArtisanats = req.getResultList();
		return listArtisanats;
		
	}

	@Override
	public Artisanat getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Artisanat a where a.ville.id= :x and a.id= :y");
		req.setParameter("x",idVille);
		req.setParameter("y", id);
		List<Artisanat> listArtisanats = req.getResultList();
		if(listArtisanats.size()==0)
		return null;
		else 
			return listArtisanats.get(0);
	}

}
