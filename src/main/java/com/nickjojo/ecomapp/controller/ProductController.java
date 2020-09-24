package com.nickjojo.ecomapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nickjojo.ecomapp.entity.Item;
import com.nickjojo.ecomapp.entity.Product;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.UserService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@GetMapping("/products/{id}")
	public String getProductPage(@PathVariable Long id, HttpSession session, HttpServletRequest request, Model model) {
		if (productService.findById(id) != null) {
			Product product = productService.findById(id).get();
			List<Product> productsByCategory = new ArrayList<>();

			for (Product p : productService.findByCategory(product.getCategory())) {
				if (p.getId().toString().equals(product.getId().toString())) {
					System.out.println(p.getName() + " already on this page");
				} else {
					productsByCategory.add(p);
				}
			}

			model.addAttribute("productsByCategory", productsByCategory);
			model.addAttribute("item", new Item());
			model.addAttribute("product", new Product());
			model.addAttribute("theProduct", product);

			return "productpage.html";
		} else {
			return "redirect:/404";
		}
	}

}
