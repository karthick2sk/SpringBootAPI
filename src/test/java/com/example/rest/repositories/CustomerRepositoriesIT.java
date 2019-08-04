package com.example.rest.repositories;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.rest.Models.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoriesIT {

	@Autowired
	CustomerRepository repo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		Optional<Customer> st = repo.findById((long) 1);
		assertNotNull(st);
	}

	public CustomerRepositoriesIT() {
		// TODO Auto-generated constructor stub
	}

}
