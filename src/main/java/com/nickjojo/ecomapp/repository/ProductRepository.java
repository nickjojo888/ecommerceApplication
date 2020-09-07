package com.nickjojo.ecomapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nickjojo.ecomapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(String name);
	
	@Query(value = "select * from Products p where p.name like %:keyword%", nativeQuery = true)
	List<Product> findByKeyWord(@Param("keyword") String keyword);
	
	@Query(value ="SELECT * FROM Products p WHERE p.stock <= 10", nativeQuery = true)
	List<Product> findAllByStock();

	@Query(value = "SELECT * FROM Products p WHERE p.category = ?1", nativeQuery = true)
	List<Product> findByCategory(String category);
	
	Optional<Product> findById(Long id);
}
