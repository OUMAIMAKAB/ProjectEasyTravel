package com.ensak.tourismeApp.dao;

import java.util.List;

import com.ensak.tourismeApp.beans.Transport;


public interface ITransportDao extends IGenericDao<Transport>{

	 public List<Transport> getVilleTransports(int idVille);
		
		public Transport getByIdAndIdVille(int id,int idVille);
}
