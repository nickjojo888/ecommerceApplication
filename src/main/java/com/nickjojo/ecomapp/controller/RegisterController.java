package com.nickjojo.ecomapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nickjojo.ecomapp.entity.Cart;
import com.nickjojo.ecomapp.entity.User;
import com.nickjojo.ecomapp.service.CartService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String showSignup(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "register.html";
	}

	@PostMapping("/signup")
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		if (userService.findByEmail(user.getEmail()) != null) {
			model.addAttribute("failure", "User already exists with this email!");
			return "register.html";
		}
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.save(user);
			cartService.save(new Cart(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("success", "Successfully signed up!");
		return "register.html";
	}

}
