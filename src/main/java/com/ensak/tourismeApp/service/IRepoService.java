package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Repo;

public interface IRepoService {

	 public Repo save(Repo entity);
		
		public Repo update(Repo entity);
		
		public List<Repo> selectAll();
		
		public List<Repo> selectAll(String sortField, String sort);
		
		public Repo getById(int id);
		
		public void remove(int id);
		
		public Repo findOne(String paramName, Object paramValue);
		
		public Repo findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		
}
