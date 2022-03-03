package com.pizza.persist.dto;

import java.util.Date;
import java.util.List;

public class PizzaOrderDTO {

	private String orderId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String address;
	private Date orderTime;
	private List<PizzaDTO> pizzaList;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
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
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public List<PizzaDTO> getPizzaList() {
		return pizzaList;
	}
	public void setPizzaList(List<PizzaDTO> pizzaList) {
		this.pizzaList = pizzaList;
	}

	
}
