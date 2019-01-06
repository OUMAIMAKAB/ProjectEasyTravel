package com.ensak.tourismeApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensak.tourismeApp.beans.MyCustomer;
import com.ensak.tourismeApp.dao.ICustomerDao;
import com.ensak.tourismeApp.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ICustomerDao dao;

	//setter for customerDao
		public void setDao(ICustomerDao dao) {
			this.dao = dao;
		}

		@Override
		public MyCustomer save(MyCustomer entity) {
			
			return dao.save(entity);
		}

		@Override
		public MyCustomer update(MyCustomer entity) {
			
			return dao.update(entity);
		}

		@Override
		public List<MyCustomer> selectAll() {
			
			return dao.selectAll();
		}

		@Override
		public List<MyCustomer> selectAll(String sortField, String sort) {
			
			return dao.selectAll(sortField, sort);
		}

		@Override
		public MyCustomer getById(int id) {
			
			return dao.getById(id);
		}

		@Override
		public void remove(int id) {
			dao.remove(id);
			
		}

		@Override
		public MyCustomer findOne(String paramName, Object paramValue) {
			
			return dao.findOne(paramName, paramValue);
		}

		@Override
		public MyCustomer findOne(String[] paramNames, Object[] paramValues) {
			
			return dao.findOne(paramNames, paramValues);
		}

		@Override
		public int findCountBy(String paramName, String paramValue) {
			
			return dao.findCountBy(paramName, paramValue);
		}

	

}
