/**
 * 
 */
package com.example.rest.controllers;


import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.Models.Customer;

import com.example.rest.Models.WordCountRequest;
import com.example.rest.Models.WordCountResponse;

import com.example.rest.service.MyRestService;

/**
 * @author sankark
 *
 */
@RestController
public class MyController {

	Logger log = LoggerFactory.getLogger(MyController.class);

	private MyRestService service;
	
	/*
	 * Method name: process
	 * Purpose: to process the POST request and return the response. response returns a JSON object of word and number of occurances. 
	 * 
	 */

	@PostMapping(path = "/count", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> process(@RequestBody WordCountRequest wordCountRequest) {

		log.debug("inside process method");

		if (wordCountRequest.getPara() == null || wordCountRequest.getPara().length() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paragraph is Empty");

		List<WordCountResponse> countList = service.findNoOfOccurance(wordCountRequest);

		log.info("Returning Response");

		return ResponseEntity.status(200).body(countList);
	}
	
	/*
	 * Method name: addCustomer
	 * Purpose: to process the POST request and return the response.  inserts the customer data in db using save method in CRUD repository. 
	 * Parameter: Customer JSON object
	 */


	@PostMapping(path = "/customer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		
		log.debug("inside addCustomer method");
		service.addCustomer(customer);
		log.info("Returning Response");
		return ResponseEntity.status(200).body("Customer data has been added.");
	}
	
	/*
	 * Method name: findCustomer
	 * Purpose: to process the GET request using id as parameter and return the response. response returns a JSON object of Customer for that ID. 
	 * Paramter: String id
	 */

	@RequestMapping(value = "/findCustomer")
	public ResponseEntity<Object> findCustomer(@RequestParam(value = "id") String id) {
		
		log.debug("inside findCustomer method");
		Optional<Customer> customer = service.findById(id);
		
		if(customer==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Data Found.");
		log.info("Returning Response");
		
		
		return ResponseEntity.status(200).body(customer);
	}
	
	
	/*
	 * Method name: findAllCustomer
	 * Purpose: to process the GET request  and return the response. response returns a JSON object of all the Customers. 
	 * Parameter: none
	 */
	
	@RequestMapping(value = "/findAllCustomer")
	public ResponseEntity<Object> findAllCustomer() {
		
		log.debug("inside findCustomer method");
		Iterable<Customer> customer = service.findAllCustomer();
		log.info("Returning Response");
		return ResponseEntity.status(200).body(customer);
	}


	public MyController(MyRestService service) {
		this.service = service;
	}
}
