package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.Station;

public interface IStationService {
	
public Station save(Station entity);
	
	public Station update(Station entity);
	
	public List<Station> selectAll();
	
	public List<Station> selectAll(String sortField, String sort);
	
	public Station getById(int id);
	
	public void remove(int id);
	
	public Station findOne(String paramName, Object paramValue);
	
	public Station findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	


}
