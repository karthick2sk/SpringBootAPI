/**
 * 
 */
package com.example.rest.service.impl;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.Models.Address;
import com.example.rest.Models.Customer;

import com.example.rest.Models.WordCountRequest;
import com.example.rest.Models.WordCountResponse;
import com.example.rest.controllers.MyController;
import com.example.rest.repositories.CustomerRepository;
import com.example.rest.service.MyRestService;

/**
 * @author sankark
 *
 */
@Service
public class MyRestServiceImpl implements MyRestService {


	private CustomerRepository customerRepo;

	Logger log = LoggerFactory.getLogger(MyController.class);
	
	/*
	 * Method name: findNOOfOccurance
	 * Purpose: to find the number of occurance of each word from the input string
	 * Parameters: WordCountRequest - Request Entity
	 */

	@Override
	public List<WordCountResponse> findNoOfOccurance(WordCountRequest wordCountRequest) {
		
		log.debug("Inside method findNoOfOccurance");

		List<WordCountResponse> wordCount = Arrays.asList(wordCountRequest.getPara().toLowerCase().split(" ")).stream() // Split the input string using space a delimiter
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream() //count each word using stream collectors
				.sorted(Map.Entry.comparingByKey())																// sort the values based on key that is words
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)) // to retain the sorted values convert it into linked hashmap
				.entrySet().stream().map(e -> new WordCountResponse(e.getKey(), e.getValue()))
				.collect(Collectors.toList());  //convert the map into list again 
		
		log.debug("Exiting Method findNoOfOccurance");
		return wordCount;
	}
	
	
	/*
	 * Method name: addCustomer
	 * Purpose: to add the customer details into customer table using the CRUD repository save
	 * Parameters: customer object
	 */

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
	
		customer.getAddresses().stream().forEach(c->c.setCustomer(customer)); // setting address from customer object
		
		
		return customerRepo.save(customer);
	}

	public MyRestServiceImpl(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	
	/*
	 * Method name: findById
	 * Purpose: to find the customer using id using the CRUD repository findById
	 * Parameter: String id
	 */
	
	@Override
	public Optional<Customer> findById(String id) {

		return customerRepo.findById(new Long(id));
	}


	/*
	 * Method name: findById
	 * Purpose: to find all the customer using the CRUD repository findById
	 * Parameter: none
	 */
	@Override
	public Iterable<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
