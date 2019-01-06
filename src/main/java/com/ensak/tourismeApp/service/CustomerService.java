package com.ensak.tourismeApp.service;

import java.util.List;

import com.ensak.tourismeApp.beans.MyCustomer;


public interface CustomerService {

    public MyCustomer save(MyCustomer entity);
	
	public MyCustomer update(MyCustomer entity);
	
	public List<MyCustomer> selectAll();
	
	public List<MyCustomer> selectAll(String sortField, String sort);
	
	public MyCustomer getById(int id);
	
	public void remove(int id);
	
	public MyCustomer findOne(String paramName, Object paramValue);
	
	public MyCustomer findOne(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
