package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.Evaluer;
import com.ensak.tourismeApp.beans.Utilisateur;
import com.ensak.tourismeApp.dao.IEvaluerDao;
import com.ensak.tourismeApp.dao.IUtilisateurDao;
import com.ensak.tourismeApp.service.IEvaluerService;

@Transactional
public class EvaluerServiceImpl implements IEvaluerService{
	
	@Autowired
	private IEvaluerDao dao;

	//setter for customerDao
		public void setDao(IEvaluerDao dao) {
			this.dao = dao;
		}
	@Override
	public Evaluer save(Evaluer entity) {
		
		return dao.save(entity);
	}

	@Override
	public List<Evaluer> selectAll() {
	
		return dao.selectAll();
	}
	@Override
	public List<Evaluer> selectAll(String sortField, String sort) {
	
		return dao.selectAll();
	}
	@Override
	public Evaluer getById(int id) {
	
		return dao.getById(id);
	}


}
