package com.nickjojo.ecomapp.entity;

import javax.servlet.http.HttpServletRequest;

public class Utilities {
	
	// Products in the cart, stored in current Session
	public static Cart getCartInSession(HttpServletRequest request) {
		
		Cart cart = (Cart) request.getSession().getAttribute("myCart");
		
		if(cart == null) {
			cart = new Cart();
			
			request.getSession().setAttribute("myCart", cart);
		}
		
		return cart;
	}

}
