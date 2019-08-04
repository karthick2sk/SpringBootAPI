/**
 * 
 */
package com.example.rest.bootStrap;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.rest.Models.Customer;
import com.example.rest.repositories.CustomerRepository;

/**
 * @author sankark
 *
 */
@Component

public class Dataload implements ApplicationListener<ContextRefreshedEvent> {

	CustomerRepository repo;

	Logger log = LoggerFactory.getLogger(Dataload.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		log.info("Starting data load..");
		repo.saveAll(loadData());
		log.info("Dataload complete !!");

	}

	private List<Customer> loadData() {
		List<Customer> customer = new ArrayList<Customer>();
		Customer c1 = new Customer();
		c1.setFst_nm("John");
		c1.setLast_nm("Snow");
		c1.setDob("01 Jan 1950");
		c1.setGender("Male");
		c1.setPhone("1234567890");
		customer.add(c1);
		
		c1 = new Customer();
		c1.setFst_nm("Arya");
		c1.setLast_nm("Stark");
		c1.setDob("01 Jan 1970");
		c1.setGender("Female");
		c1.setPhone("9876543210");
		customer.add(c1);

		return customer;

	}

	public Dataload(CustomerRepository repo) {
		this.repo = repo;
	}

}
