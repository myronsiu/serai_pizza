package com.pizza.receiver.dto;

public class PizzaDTO {

	private String pizzaId;
	private String name;
	private Integer quantity;
	
	public String getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
