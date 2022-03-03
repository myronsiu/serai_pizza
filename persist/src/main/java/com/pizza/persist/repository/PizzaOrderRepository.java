package com.pizza.persist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizza.persist.entity.PizzaOrder;

@Repository
public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long>{

}
