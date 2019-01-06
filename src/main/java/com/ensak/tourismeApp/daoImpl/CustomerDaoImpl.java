package com.ensak.tourismeApp.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ensak.tourismeApp.beans.MyCustomer;
import com.ensak.tourismeApp.dao.ICustomerDao;


@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends GenericDaoImpl<MyCustomer> implements ICustomerDao{

	
}
