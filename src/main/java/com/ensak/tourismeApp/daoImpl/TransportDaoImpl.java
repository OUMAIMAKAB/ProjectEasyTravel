package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Transport;
import com.ensak.tourismeApp.dao.ITransportDao;

public class TransportDaoImpl  extends GenericDaoImpl<Transport> implements ITransportDao{

	@Override
	public List<Transport> getVilleTransports(int idVille) {
		Query req=em.createQuery("select a from Transport a where a.ville.id= :x");
		req.setParameter("x",idVille);
		List<Transport> listTransports = req.getResultList();
		return listTransports;
	}

	@Override
	public Transport getByIdAndIdVille(int id, int idVille) {
		Query req=em.createQuery("select a from Transport a where a.ville.id= :x and a.id= :y");
		req.setParameter("x", idVille);
		req.setParameter("y", id);
		List<Transport> listTransports = req.getResultList();
		if(listTransports.size()==0) {
		     return null;	
		}else {
			return listTransports.get(0);
		}
	}

}
