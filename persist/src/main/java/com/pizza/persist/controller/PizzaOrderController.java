package com.pizza.persist.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.persist.dto.NewOrderDTO;
import com.pizza.persist.dto.PizzaDTO;
import com.pizza.persist.dto.PizzaOrderDTO;
import com.pizza.persist.entity.Pizza;
import com.pizza.persist.entity.PizzaOrder;
import com.pizza.persist.service.PizzaOrderService;

@RestController
@RequestMapping("order")
public class PizzaOrderController {
	
	Logger logger = LoggerFactory.getLogger(PizzaOrderController.class);
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PizzaOrderService orderService;

	@GetMapping("/{id}")
	public PizzaOrderDTO getOrder(@RequestHeader("Authorization") String session, @PathVariable("id") long orderId, HttpServletResponse response) {
		PizzaOrderDTO pizzaOrderDTO = null;
		
		// TODO change authentication method
		if (session.equals("Basic access_token")) {
			logger.info("getOrder - Authorized");
			
			// get order from database
			PizzaOrder order = orderService.getOrder(orderId);
			
			// parse entity to DTO
			if (order != null) {
				Type pizzaListType = new TypeToken<List<PizzaDTO>>() {}.getType();
				List<PizzaDTO> pizzaList = modelMapper.map(order.getPizzaList(), pizzaListType);
				pizzaOrderDTO = modelMapper.map(order, PizzaOrderDTO.class);
				pizzaOrderDTO.setPizzaList(pizzaList);
				logger.info("getOrder - Order returned, id: " + pizzaOrderDTO.getOrderId());
			}
		} else {
			logger.info("getOrder - Unauthorized access");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return pizzaOrderDTO;
	}
	
	@PostMapping("/")
	public PizzaOrderDTO newOrder(@RequestHeader("Authorization") String session, @RequestBody NewOrderDTO newOrder, HttpServletResponse response) {
		PizzaOrderDTO submittedOrder = null;
		
		// TODO change authentication method
		if (session.equals("Basic access_token")) {
			logger.info("newOrder - Authorized");
			
			// parse DTO to entity
			Type pizzaListType = new TypeToken<List<Pizza>>() {}.getType();
			List<Pizza> pizzaList = modelMapper.map(newOrder.getPizzaList(), pizzaListType);
			PizzaOrder order = modelMapper.map(newOrder, PizzaOrder.class);
			order.setPizzaList(pizzaList);
			
			// submit entity
			order = orderService.submitOrder(order);
			
			// parse result entity to DTO 
			if (order != null) {
				Type pizzaDTOListType = new TypeToken<List<PizzaDTO>>() {}.getType();
				List<PizzaDTO> pizzaDTOList = modelMapper.map(order.getPizzaList(), pizzaDTOListType);
				submittedOrder = modelMapper.map(order, PizzaOrderDTO.class);
				submittedOrder.setPizzaList(pizzaDTOList);
				logger.info("newOrder - Order submitted, id: " + submittedOrder.getOrderId());
			}
		} else {
			logger.info("newOrder - Unauthorized access");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return submittedOrder;
	}
}
