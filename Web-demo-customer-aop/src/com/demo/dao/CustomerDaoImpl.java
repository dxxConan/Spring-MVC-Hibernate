package com.demo.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Customer;

//for Dao implementation
@Repository
public class CustomerDaoImpl implements CustomerDao {
	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//we now do the transaction in service layer
	@Override
//	@Transactional
	//spring will do the transaction
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query, sort by lastname
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		//execute query and get result
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer 
		//if the primary key exist then do a update, or do a save
		currentSession.saveOrUpdate(theCustomer);
	}
	@Override
	public Customer getCustomerById(int thisId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//get data from database by primary key
		Customer thisCustomer = currentSession.get(Customer.class, thisId);
		return thisCustomer;
	}
	@Override
	public void deleteCustomer(int thisId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", thisId);
		theQuery.executeUpdate();
	}

}
