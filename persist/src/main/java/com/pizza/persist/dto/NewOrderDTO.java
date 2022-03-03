package com.pizza.persist.dto;

import java.util.List;

public class NewOrderDTO {
	
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String address;	
	private List<PizzaDTO> pizzaList;
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<PizzaDTO> getPizzaList() {
		return pizzaList;
	}
	public void setPizzaList(List<PizzaDTO> pizzaList) {
		this.pizzaList = pizzaList;
	}
}
