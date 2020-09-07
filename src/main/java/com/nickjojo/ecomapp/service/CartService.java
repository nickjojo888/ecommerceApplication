package com.nickjojo.ecomapp.service;

import java.util.Optional;

import com.nickjojo.ecomapp.entity.Cart;

public interface CartService {
	
//	Long getCart_IdByUser_Id(Long userId);
	
	Optional<Cart> findById(Long id);
	
	void save(Cart cart);
	
}
