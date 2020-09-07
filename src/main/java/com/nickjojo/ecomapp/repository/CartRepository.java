package com.nickjojo.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nickjojo.ecomapp.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

//	@Query("select cart_id from Cart c where c.user.getId() = :userId")
//	Long getCart_IdByUser_Id(@Param("userId") Long userId);
	
//	@Query("FROM cart c where c.user_id = :user_id")
//	Cart findCartByUser_Id(Long user_id);

}
