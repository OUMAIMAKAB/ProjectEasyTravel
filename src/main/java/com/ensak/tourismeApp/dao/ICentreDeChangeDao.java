package com.ensak.tourismeApp.dao;

import java.util.List;


import com.ensak.tourismeApp.beans.CentreDeChange;

public interface ICentreDeChangeDao extends IGenericDao<CentreDeChange>{

	   public List<CentreDeChange> getVilleCentreDeChanges(int idVille);
		
		public CentreDeChange getByIdAndIdVille(int id,int idVille);
}
