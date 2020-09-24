package com.nickjojo.ecomapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nickjojo.ecomapp.entity.Item;
import com.nickjojo.ecomapp.entity.Product;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class HomeController {

	@Autowired
	public UserService userService;

	@Autowired
	public ProductService productService;

	@GetMapping("/")
	public String showIndex(Model model) {
		List<Product> products = productService.findAllByStock();

		model.addAttribute("popularProducts", products);
		model.addAttribute("item", new Item());
		model.addAttribute("product", new Product());

		return "index.html";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login.html";
	}

	@PostMapping("/search/")
	public String searchProducts(@ModelAttribute("product") Product product, Model model) {

		// once this works, delegate it to the repository (e.g: findProductsByQuery)

		ArrayList<Product> productsMatching = new ArrayList<>();

		for (Product p : productService.findAll()) {
			String[] words = p.getName().split(" ");
			for (String word : words) {
				if (word.equalsIgnoreCase(product.getName())) {
					productsMatching.add(p);
				}
			}

			if (productService.findByName(product.getName()) != null) {
				productsMatching.add(productService.findByName(product.getName()));
			}
		}

		if (productsMatching.isEmpty()) {
			model.addAttribute("noProduct", "No products match this query!");
			return "search.html";
		}

		model.addAttribute("productsMatching", productsMatching);
		return "search.html";
	}

}