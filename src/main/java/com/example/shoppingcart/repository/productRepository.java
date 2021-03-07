package com.example.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shoppingCart.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {

	
 	@Query("select p from Product p where p.productName= :productname")
 	Product getProductbyproductName(String productname);

	

}
