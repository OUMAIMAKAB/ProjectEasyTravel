package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.CentreDeChange;

public interface ICentreDeChangeService {

	 public CentreDeChange save(CentreDeChange entity);
		
		public CentreDeChange update(CentreDeChange entity);
		
		public List<CentreDeChange> selectAll();
		
		public List<CentreDeChange> selectAll(String sortField, String sort);
		
		public CentreDeChange getById(int id);
		
		public void remove(int id);
		
		public CentreDeChange findOne(String paramName, Object paramValue);
		
		public CentreDeChange findOne(String[] paramNames, Object[] paramValues);
		
		public int findCountBy(String paramName, String paramValue);
		
		public List<CentreDeChange> getVilleCentreDeChanges(int idVille);
		
		public CentreDeChange getByIdAndIdVille(int id,int idVille);
}
