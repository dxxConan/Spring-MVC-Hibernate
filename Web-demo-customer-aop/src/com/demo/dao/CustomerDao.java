package com.demo.dao;

import com.demo.entity.Customer;

import java.util.List;

public interface CustomerDao {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomerById(int thisId);

	public void deleteCustomer(int thisId);
	
}
