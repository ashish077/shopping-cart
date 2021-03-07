package com.example.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingCart.entity.Cart;

@Repository
public interface cartRepository extends JpaRepository<Cart,Integer> {

	
	
}
