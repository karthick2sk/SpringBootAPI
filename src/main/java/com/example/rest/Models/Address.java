package com.example.rest.Models;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author sankark
 *
 */
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Address cannot be empty.")
	private String addr_ln1;
	private String addr_ln2;
	@NotEmpty(message = "City cannot be empty.")
	private String city;
	@NotEmpty(message = "State cannot be empty.")
	private String state;
	//@NotEmpty(message = "Zip Code cannot be empty.")
	private int zip;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	@JsonIgnoreProperties("addresses")
	private Customer customer;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddr_ln1() {
		return addr_ln1;
	}

	public void setAddr_ln1(String addr_ln1) {
		this.addr_ln1 = addr_ln1;
	}

	public String getAddr_ln2() {
		return addr_ln2;
	}

	public void setAddr_ln2(String addr_ln2) {
		this.addr_ln2 = addr_ln2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
