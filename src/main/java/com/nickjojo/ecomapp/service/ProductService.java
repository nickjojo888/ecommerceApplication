package com.nickjojo.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.nickjojo.ecomapp.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findByName(String name);

	List<Product> findByKeyWord(@Param("keyword") String keyword);

	List<Product> findAllByStock();

	List<Product> findByCategory(String category);

	Optional<Product> findById(Long id);
	
}
