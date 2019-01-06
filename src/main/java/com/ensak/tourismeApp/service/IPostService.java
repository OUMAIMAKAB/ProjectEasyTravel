package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Post;

public interface IPostService {
	 public Post save(Post  entity);
		
		public Post  update(Post  entity);
		
		public List<Post> selectAll();
		
		public List<Post> selectAll(String sortField, String sort);
		
		public Post getById(int id);
		
		public void remove(int id);
		
		public Post  findOne(String paramName, Object paramValue);
		
		public Post  findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<Post > getUtilisateurPost(int idUtilisateur);
		
		public Post  getByIdAndIdUtilisateur(int id,int idUtilisateur);
		
		//public void insertByIdUtilisateur(int id, String texte, int idUtilisateur);
}
