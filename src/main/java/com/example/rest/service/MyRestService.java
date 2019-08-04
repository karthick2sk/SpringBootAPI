/**
 * 
 */
package com.example.rest.service;

import java.util.List;

import java.util.Optional;



import com.example.rest.Models.Customer;

import com.example.rest.Models.WordCountRequest;
import com.example.rest.Models.WordCountResponse;


/**
 * @author sankark
 *
 */
public interface MyRestService {
	
	
	public List<WordCountResponse> findNoOfOccurance(WordCountRequest wordCountRequest);
	public Customer addCustomer(Customer customer);
	public Optional<Customer> findById(String id);
	public Iterable<Customer> findAllCustomer();

}
