package com.nickjojo.ecomapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nickjojo.ecomapp.entity.Product;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class CatalogController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@GetMapping("/catalog")
	public String getCatalog(Model model) {
		model.addAttribute("product", new Product());

		List<Product> products = new ArrayList<>();

		// Find all by stock to get the popular ones displayed
		for (Product product : productService.findAllByStock()) {
			products.add(product);
		}

		model.addAttribute("allProducts", products);

		return "catalog.html";
	}

	@GetMapping("/catalog/{category}")
	public String getProductsByCategory(@PathVariable String category, Model model) {
		model.addAttribute("product", new Product());

		List<Product> products = productService.findByCategory(category);

		model.addAttribute("products", products);

		return "category-catalog.html";

	}
}
