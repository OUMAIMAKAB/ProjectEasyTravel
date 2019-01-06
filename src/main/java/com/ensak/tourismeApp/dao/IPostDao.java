package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;

public interface IPostDao extends IGenericDao<Post> {

public List<Post> getUtilisateurPost(int idUtilisateur);
	
	public Post getByIdAndIdUtilisateur(int id,int idUtilisateur);
	
	//public void insertByIdUtilisateur(int id,String texte, int idUtilisateur);
}



