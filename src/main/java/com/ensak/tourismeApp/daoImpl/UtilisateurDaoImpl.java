package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.dao.IUtilisateurDao;

public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur> implements IUtilisateurDao{
	@Override
	public Utilisateur getByIdAndIdUtilisateur(String nom,String password) {
		
		Query req=em.createQuery("select a from Utilisateur a where a.nom= :x and a.password= :y");
		req.setParameter("x", nom);
		req.setParameter("y", password);
		List<Utilisateur> listUtilisateur = req.getResultList();
		if(listUtilisateur.size()==0) {
		     return null;	
		}else {
			return listUtilisateur.get(0);
		}
		
	}
}
