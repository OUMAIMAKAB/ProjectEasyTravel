package com.ensak.tourismeApp.daoImpl;

import java.util.List;

import javax.persistence.Query;

import com.ensak.tourismeApp.beans.Banque;
import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.dao.IPostDao;
import com.ensak.tourismeApp.dao.IUtilisateurDao;

public class PostDaoImpl extends GenericDaoImpl<Post> implements IPostDao{
	
	@Override
	public List<Post> getUtilisateurPost(int idUtilisateur) {
		Query req=em.createQuery("select a from Post a where a.utilisateur.id= :x");
		req.setParameter("x",idUtilisateur);
		List<Post> listPost = req.getResultList();
		return listPost;
	}

	@Override
	public Post getByIdAndIdUtilisateur(int id,int idUtilisateur){
		Query req=em.createQuery("select a from Post a where a.utilisateur.id= :x and a.id= :y");
		req.setParameter("x", idUtilisateur);
		req.setParameter("y", id);
		List<Post> listPost = req.getResultList();
		if(listPost.size()==0) {
		     return null;	
		}else {
			return listPost.get(0);
		}
	}
//	@Override
	//public void insertByIdUtilisateur(int id, String texte, int idUtilisateur) {
		
		//Query query = em.createQuery("INSERT INTO Post (id, texte, idUtilisateur) VALUES (?, ?, ?)");
		//query.setParameter(1, id);
		//query.setParameter(2, texte);
		//query.setParameter(2, idUtilisateur);
		
		//query.executeUpdate();
		
	//}


}
