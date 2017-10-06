package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.demo.entity.Customer;
import com.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer dao
	
	/*
	//spring will scan for a component that implements customerDao interface
	@Autowired
	private CustomerDao cusDao;
	
	*/
	
	//need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get customers from dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		//go to the jsp page
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int thisId, Model theModel) {
		//get the customer from the database
		Customer theCustomer = customerService.getCustomerById(thisId);
		//set customer as a model attribute
		theModel.addAttribute("customer", theCustomer);
		//send over to out form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int thisId, Model theModel) {
		//delete cutstomer by id
		customerService.deleteCustomer(thisId);
		return "redirect:/customer/list";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
