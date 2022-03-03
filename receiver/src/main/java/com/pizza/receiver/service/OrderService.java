package com.pizza.receiver.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pizza.receiver.dto.PizzaOrderDTO;

@Component
public class OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public PizzaOrderDTO getOrder(Long orderId){
		PizzaOrderDTO order = null;
		 
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			// TODO change authentication method
			// set access token for authentication
			HttpHeaders headers = new HttpHeaders();
			headers.setBasicAuth("access_token");
			HttpEntity httpEntity = new HttpEntity(headers);
			
			// send request
			order = restTemplate.exchange(
					new URI("http://localhost:4588/order/" + orderId), HttpMethod.GET, httpEntity, PizzaOrderDTO.class).getBody();
		} catch (Exception e) {
			logger.error("getOrder - failed to get order: " + e.getMessage(), e);
		}
		
		return order;
	}
	
	public PizzaOrderDTO sendOrder(PizzaOrderDTO pizzaOrderDTO){
		PizzaOrderDTO submittedOrder = null;
		
		try {
			RestTemplate restTemplate = new RestTemplate();
	
			// TODO change authentication method
			// set access token for authentication
			HttpHeaders headers = new HttpHeaders();
			headers.setBasicAuth("access_token");
			HttpEntity<PizzaOrderDTO> httpEntity = new HttpEntity<PizzaOrderDTO>(pizzaOrderDTO, headers);
			
			// send request
			submittedOrder = restTemplate.postForObject(
					new URI("http://localhost:4588/order/"), httpEntity, PizzaOrderDTO.class);
		} catch (Exception e) {
			logger.error("submitOrder - failed to save: " + e.getMessage(), e);
		}
		
		return submittedOrder;
	}

}
