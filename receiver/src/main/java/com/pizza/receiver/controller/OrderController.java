package com.pizza.receiver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.receiver.dto.PizzaDTO;
import com.pizza.receiver.dto.PizzaOrderDTO;
import com.pizza.receiver.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/{id}")
	public PizzaOrderDTO getOrder(@PathVariable("id") Long orderId) {
		PizzaOrderDTO pizzaOrderDTO = null;
		
		pizzaOrderDTO = orderService.getOrder(orderId);
		
		if (pizzaOrderDTO != null) {
			logger.info("getOrder - Order returned, id: " + pizzaOrderDTO.getOrderId());
		} else {
			logger.info("getOrder - order not found, id: " + orderId);
		}
		
		return pizzaOrderDTO;
	}
	
	@GetMapping("/random")
	public PizzaOrderDTO randomNewOrder() {
		PizzaOrderDTO pizzaOrderDTO = null;
		
		// generate random pizza list for the order
		Random random = new Random();
		List<PizzaDTO> pizzaList = new ArrayList<PizzaDTO>();
		for (int i = 0; i < random.nextInt(3) + 1; i++) {
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setName("Pizza " + (random.nextInt(10) + 1));
			pizzaDTO.setQuantity(random.nextInt(10) + 1);
			pizzaList.add(pizzaDTO);
		}
		PizzaOrderDTO newOrder = new PizzaOrderDTO();
		newOrder.setFirstName("Peter");
		newOrder.setLastName("Wong");
		newOrder.setContactNumber("12312312");
		newOrder.setEmail("ab@com.com");
		newOrder.setAddress("Hong Kong");
		newOrder.setPizzaList(pizzaList);
		
		// submit the order
		pizzaOrderDTO = orderService.sendOrder(newOrder);
		
		if (pizzaOrderDTO != null) {
			logger.info("randomNewOrder - Order submitted, id: " + pizzaOrderDTO.getOrderId());
		} else {
			logger.info("randomNewOrder - failed to submit");
		}

		return pizzaOrderDTO;
	}
	
	@PostMapping("/")
	public PizzaOrderDTO newOrder(@RequestBody PizzaOrderDTO newOrder) {
		PizzaOrderDTO pizzaOrderDTO = null;
		
		pizzaOrderDTO = orderService.sendOrder(newOrder);
		
		if (pizzaOrderDTO != null) {
			logger.info("randomNewOrder - Order submitted, id: " + pizzaOrderDTO.getOrderId());
		} else {
			logger.info("randomNewOrder - failed to submit");
		}

		return pizzaOrderDTO;
	}
}
