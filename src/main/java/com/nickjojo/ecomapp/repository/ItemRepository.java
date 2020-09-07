package com.nickjojo.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nickjojo.ecomapp.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
//	@Query(value ="INSERT INTO cartitems(quantity, price, cart_id, product_id) VALUES(%e.getQuantity()%, %e.getPrice()%, :cart_id, %e.getProduct().getId()%", nativeQuery = true)
//	void saveCartItemsByUserId(CartItems e, @Param("cart_id") Long cart_id);

	// and one for remove
}
