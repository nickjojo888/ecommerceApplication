package com.nickjojo.ecomapp.config;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nickjojo.ecomapp.repository.OrderCreatedServiceImpl;
import com.nickjojo.ecomapp.service.CartService;
import com.nickjojo.ecomapp.service.CartServiceImpl;
import com.nickjojo.ecomapp.service.OrderCreatedService;
import com.nickjojo.ecomapp.service.ProductService;
import com.nickjojo.ecomapp.service.ProductServiceImpl;
import com.nickjojo.ecomapp.service.UserService;
import com.nickjojo.ecomapp.service.UserServiceImpl;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.nickjojo.ecomapp")
@ComponentScan({ "com.nickjojo.ecomapp" })
@EnableJpaRepositories("com.nickjojo.ecomapp.repository")
@EntityScan("com.nickjojo.ecomapp.entity")
public class EcommerceApp implements CommandLineRunner, WebMvcConfigurer {

	// change app, delete cartitems, use httpsessions to get current user
	// when user orders product, get their session and their cart and save it to
	// database
	// then flush data from their session.
	
	/*
	 * 1). Finish product.html page*
	 */
	
	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**", "/css/**", "/libs/**").addResourceLocations("classpath:/static/img/",
				"classpath:/static/css/", "classpath:/static/libs/");
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApp.class, args);

	}

	@Bean
	public CartService cartService() {
		return new CartServiceImpl();
	}
	
	@Bean
	public OrderCreatedService OrderCreatedService() {
		return new OrderCreatedServiceImpl();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	

}


