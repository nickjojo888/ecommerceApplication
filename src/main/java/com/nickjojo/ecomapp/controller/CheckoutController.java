package com.nickjojo.ecomapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nickjojo.ecomapp.entity.Item;
import com.nickjojo.ecomapp.entity.OrderCreated;
import com.nickjojo.ecomapp.entity.PaymentDetails;
import com.nickjojo.ecomapp.entity.User;
import com.nickjojo.ecomapp.service.OrderCreatedService;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class CheckoutController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderCreatedService orderCreatedService;

	@Autowired
	private UserService userService;

	@GetMapping("/checkout")
	public String getCheckout(Model model, HttpSession session) {

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		User user = new User();

		double price = 0;
		for (Item item : cart) {
			price += item.getQuantity() * item.getProduct().getPrice();
		}

		model.addAttribute("totalPrice", price);
		model.addAttribute("user", user);
		model.addAttribute("cart", cart);
		model.addAttribute("paymentDetails", new PaymentDetails());

		return "checkout.html";

	}

	@PostMapping("/checkout")
	public String checkoutCart(Model model, HttpSession session,
			@ModelAttribute("paymentDetails") PaymentDetails paymentDetails) {

		// turn cart into cart object
		List<Item> cart = (List<Item>) session.getAttribute("cart");

		for (Item item : cart) {
			OrderCreated orderCreated = new OrderCreated(LocalDateTime.now(), paymentDetails.getFirstName(),
					paymentDetails.getLastName(), item.getProduct().getId(), item.getQuantity());
			orderCreatedService.saveOrderCreated(orderCreated);
		}

		cart.clear();
		return "redirect:/checkout-success";

	}

	@GetMapping("/checkout-success")
	public String checkoutSuccess(Model model) {

		return "checkout-success.html";
	}
}
