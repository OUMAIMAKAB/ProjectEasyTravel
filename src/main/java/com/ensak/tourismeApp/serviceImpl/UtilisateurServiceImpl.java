package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Post;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.dao.IUtilisateurDao;
import com.ensak.tourismeApp.service.IUtilisateurService;

@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{

	@Autowired
	private IUtilisateurDao dao;

	//setter for customerDao
		public void setDao(IUtilisateurDao dao) {
			this.dao = dao;
		}
	@Override
	public Utilisateur save(Utilisateur entity) {
		
		return dao.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}
	
	@Override
	public Utilisateur  getByIdAndIdUtilisateur(String nom,String password) {
		return dao.getByIdAndIdUtilisateur(nom, password);
	}

}
