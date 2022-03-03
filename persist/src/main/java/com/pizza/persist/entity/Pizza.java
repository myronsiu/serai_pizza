package com.pizza.persist.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pizza {
	
	public Pizza() {
		super();
	}
	
	public Pizza(Long pizzaId, String name, Integer quantity) {
		super();
		this.pizzaId = pizzaId;
		this.name = name;
		this.quantity = quantity;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pizzaId;
	@Column
	private String name;
	@Column
	private Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private PizzaOrder order;
	
	public Long getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Long pizzaId) {
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
	public PizzaOrder getOrder() {
		return order;
	}
	public void setOrder(PizzaOrder order) {
		this.order = order;
	}
	
		
}
