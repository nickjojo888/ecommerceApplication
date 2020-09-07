package com.nickjojo.ecomapp.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.nickjojo.ecomapp.entity.OrderCreated;
import com.nickjojo.ecomapp.service.OrderCreatedService;

public class OrderCreatedServiceImpl implements OrderCreatedService {

	@Autowired
	private OrderCreatedRepository orderCreatedRepository;
	
	@Override
	public void saveOrderCreated(OrderCreated orderCreated) {
		orderCreatedRepository.save(orderCreated);
	}

}
