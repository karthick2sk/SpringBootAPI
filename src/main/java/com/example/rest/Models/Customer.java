package com.example.rest.Models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author sankark
 *
 */
@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Please provide first name")
	private String fst_nm;
	@NotEmpty(message = "Please provide last name")
	private String last_nm;
	@NotEmpty(message = "Please provide Date of Birth name")
	private String dob;
	@NotEmpty(message = "Please provide gender name")
	private String gender;
	@Size(min = 10, max = 10)
	private String phone;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	Set<Address> addresses = new HashSet<Address>();

	public Customer addAddresses(Address address) {

		address.setCustomer(this);
		this.addresses.add(address);

		return this;

	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFst_nm() {
		return fst_nm;
	}

	public void setFst_nm(String fst_nm) {
		this.fst_nm = fst_nm;
	}

	public String getLast_nm() {
		return last_nm;
	}

	public void setLast_nm(String last_nm) {
		this.last_nm = last_nm;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	

}
