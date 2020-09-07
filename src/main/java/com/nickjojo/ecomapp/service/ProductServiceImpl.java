package com.nickjojo.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickjojo.ecomapp.entity.Product;
import com.nickjojo.ecomapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> findByKeyWord(String keyword) {
		return productRepository.findByKeyWord(keyword);
	}

	@Override
	public List<Product> findAllByStock() {
		return productRepository.findAllByStock();
	}

	@Override
	public List<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

}
