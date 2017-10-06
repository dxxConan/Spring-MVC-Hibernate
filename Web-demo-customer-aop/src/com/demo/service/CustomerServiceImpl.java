package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	//need to inject customer dao
	
	@Autowired
	private CustomerDao customerDao;
	
	//define the tansaction in service layer
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int thisId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(thisId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int thisId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(thisId);
	}

}
