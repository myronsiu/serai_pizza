package com.pizza.persist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pizza.persist.entity.Pizza;
import com.pizza.persist.entity.PizzaOrder;
import com.pizza.persist.repository.PizzaOrderRepository;
import com.pizza.persist.service.PizzaOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaOrderTest {

	@MockBean
	private PizzaOrderRepository pizzaOrderRepository;
	@Autowired
	private PizzaOrderService pizzaOrderService;
	
	@Test
	void getPizzaOrderById() {
		PizzaOrder mockPizzaOrderA = new PizzaOrder(1l, "Peter", "Chan", "98989898", "pc@gmail.com", "Shatin", new Date(), null);
		List<Pizza> mockPizzaListA = new ArrayList<Pizza>();
		mockPizzaListA.add(new Pizza(5l, "Pizza a", 1));
		mockPizzaListA.add(new Pizza(6l, "Pizza b", 2));
		mockPizzaOrderA.setPizzaList(mockPizzaListA);
		PizzaOrder mockPizzaOrderB = new PizzaOrder(2l, "Mary", "Wong", "95959595", "mw@gmail.com", "Mongkok", new Date(), null);
		List<Pizza> mockPizzaListB = new ArrayList<Pizza>();
		mockPizzaListB.add(new Pizza(7l, "Pizza c", 1));
		mockPizzaListB.add(new Pizza(8l, "Pizza d", 2));
		mockPizzaListB.add(new Pizza(9l, "Pizza e", 3));
		mockPizzaOrderB.setPizzaList(mockPizzaListB);
		Mockito.when(pizzaOrderRepository.findById(1l)).thenReturn(Optional.of(mockPizzaOrderA));
		Mockito.when(pizzaOrderRepository.findById(2l)).thenReturn(Optional.of(mockPizzaOrderB));
		
		PizzaOrder pizzaOrderA = pizzaOrderService.getOrder(1);
		Assert.assertNotNull(pizzaOrderA);
		Assert.assertEquals(pizzaOrderA.getContactNumber(), "98989898");
		Assert.assertEquals(pizzaOrderA.getPizzaList().size(), 2);
		
		PizzaOrder pizzaOrderB = pizzaOrderService.getOrder(2);
		Assert.assertNotNull(pizzaOrderB);
		Assert.assertEquals(pizzaOrderB.getContactNumber(), "95959595");
		Assert.assertEquals(pizzaOrderB.getPizzaList().size(), 3);
		
		PizzaOrder pizzaOrderC = pizzaOrderService.getOrder(3);
		Assert.assertNull(pizzaOrderC);
	}

	@Test
	void savePizzaOrder() {
		PizzaOrder newPizzaOrderA = new PizzaOrder(null, "Peter", "Chan", "98989898", "pc@gmail.com", "Shatin", new Date(), null);
		List<Pizza> newPizzaListA = new ArrayList<Pizza>();
		newPizzaListA.add(new Pizza(5l, "Pizza a", 1));
		newPizzaListA.add(new Pizza(6l, "Pizza b", 2));
		newPizzaOrderA.setPizzaList(newPizzaListA);
		
		PizzaOrder mockPizzaOrderA = new PizzaOrder(1l, "Peter", "Chan", "98989898", "pc@gmail.com", "Shatin", new Date(), null);
		List<Pizza> mockPizzaListA = new ArrayList<Pizza>();
		mockPizzaListA.add(new Pizza(5l, "Pizza a", 1));
		mockPizzaListA.add(new Pizza(6l, "Pizza b", 2));
		mockPizzaOrderA.setPizzaList(mockPizzaListA);
		
		Mockito.when(pizzaOrderRepository.save(newPizzaOrderA)).thenReturn(mockPizzaOrderA);
		
		PizzaOrder pizzaOrderA = pizzaOrderService.submitOrder(newPizzaOrderA);
		Assert.assertNotNull(pizzaOrderA);
		Assert.assertEquals(pizzaOrderA.getContactNumber(), "98989898");
		Assert.assertEquals(pizzaOrderA.getPizzaList().size(), 2);
	}
}
