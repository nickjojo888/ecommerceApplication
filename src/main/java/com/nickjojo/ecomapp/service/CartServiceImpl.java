package com.nickjojo.ecomapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nickjojo.ecomapp.entity.Cart;
import com.nickjojo.ecomapp.repository.CartRepository;

public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
//	@Override
//	public Long getCart_IdByUser_Id(Long userId) {
//		return cartRepository.getCart_IdByUser_Id(userId);
//	}

	@Override
	public Optional<Cart> findById(Long id) {
		return cartRepository.findById(id);
	}

	@Override
	public void save(Cart cart) {
		cartRepository.save(cart);
	}



}
