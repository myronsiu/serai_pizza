package com.pizza.persist.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pizza.persist.entity.PizzaOrder;
import com.pizza.persist.repository.PizzaOrderRepository;

@Component
public class PizzaOrderService {
	
	Logger logger = LoggerFactory.getLogger(PizzaOrderService.class);
	
	@Autowired
	private PizzaOrderRepository orderRepository;
	
	public PizzaOrder getOrder(long orderId) {	
		PizzaOrder pizzaOrder = null;
		
		try {
			Optional<PizzaOrder> orderOptional = orderRepository.findById(orderId);
			pizzaOrder = orderOptional.orElse(null);
		} catch (Exception e) {
			logger.error("getOrder - failed to get order: " + e.getMessage(), e);
		}
		
		return pizzaOrder;
	}
	
	public PizzaOrder submitOrder(PizzaOrder order) {
		PizzaOrder newOrder = null;
		
		try {
			newOrder = orderRepository.save(order);
		} catch (Exception e) {
			logger.error("submitOrder - failed to save: " + e.getMessage(), e);
		}

		return newOrder;
	}

}
