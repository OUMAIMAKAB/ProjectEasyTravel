package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Evaluer;
import com.ensak.tourismeApp.beans.Utilisateur;

public interface IEvaluerService {
	
	public Evaluer save(Evaluer entity);
	public List<Evaluer> selectAll();
	
	public List<Evaluer> selectAll(String sortField, String sort);
	
	public Evaluer getById(int id);
}
