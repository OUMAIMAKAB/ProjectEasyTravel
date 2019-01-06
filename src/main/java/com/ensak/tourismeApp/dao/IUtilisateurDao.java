package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;

public interface IUtilisateurDao extends IGenericDao<Utilisateur>{
	
	public Utilisateur getByIdAndIdUtilisateur(String nom,String password);
}
