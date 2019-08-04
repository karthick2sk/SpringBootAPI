/**
 * 
 */
package com.example.rest.repositories;



import org.springframework.data.repository.CrudRepository;

import com.example.rest.Models.Customer;


/**
 * @author sankark
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {



}
