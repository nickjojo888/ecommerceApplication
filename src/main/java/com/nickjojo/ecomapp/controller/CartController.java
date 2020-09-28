package com.nickjojo.ecomapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nickjojo.ecomapp.entity.Item;
import com.nickjojo.ecomapp.entity.Product;
import com.nickjojo.ecomapp.service.CartService;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class CartController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	// if user is a member, save data to DB. If not, use requests and flush data

	@GetMapping("/cart")
	public String getCart(Model model, HttpSession session, HttpServletRequest req) {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) {
			if (session.getAttribute("cart") == null) {
				System.out.println("session null");
				List<Item> cart = new ArrayList<>();
				session.setAttribute("cart", cart);
				return "cart.html";
			}
		} else {
			System.out.println("session not null");
			List<Item> cart = (List<Item>) req.getSession().getAttribute("cart");
			model.addAttribute("cart", cart);
			return "cart.html";
		}
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		model.addAttribute("cart", cart);
	
		model.addAttribute("itemsInCart", session.getAttribute("itemsInCart"));
		
		return "cart.html";
	}

	@PostMapping("/cart/{id}")
	public String addProduct(@PathVariable Long id, HttpServletRequest request, @ModelAttribute("item") Item item,
			Model model, HttpSession session) {

		
	if(item.getQuantity() <= 0) {
		item.setQuantity(1);
	}
	
		if (session.getAttribute("cart") == null) {
			System.out.println("session null");
			List<Item> cart = new ArrayList<>();
			Optional<Product> product = productService.findById(id);
			item.setProduct(product.get());
			cart.add(item);
			System.out.println("Added " + item.getProduct().getName());
			session.setAttribute("cart", cart);
		} else {
			System.out.println("session not null");
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = this.exists(id, cart);
			if (index == -1) {
				
				cart.add(new Item(productService.findById(id).get(), item.getQuantity()));
			} else {
				cart.add(new Item(productService.findById(id).get(), + cart.get(index).getQuantity() + item.getQuantity()));
				cart.remove(index);
				return "redirect:/cart/";

			}
			session.setAttribute("cart", cart);
			session.setAttribute("itemsInCart", Integer.toString(cart.size()));
		}
		return "redirect:/cart/";
	}

	@PostMapping("/cart/delete/{productId}")
	public String deleteItem(@PathVariable Long productId, Model model, HttpSession session) {
		Optional<Product> product = productService.findById(productId);
		List<Item> cart = (List<Item>) session.getAttribute("cart");

		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == product.get().getId()) {
				cart.remove(i);
				List<Item> newCart = new ArrayList<Item>();
				newCart.addAll(cart);
				session.setAttribute("cart", newCart);
			}
		}
		return "redirect:/cart";

	}

	private int exists(Long id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
//	@PostMapping("/cart/edit/{cartItemId}/{quantity}")
//	public String editQuantity() {
//		
//	}
}
