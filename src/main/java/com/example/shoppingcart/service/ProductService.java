package com.example.shoppingCart.service;

import java.util.List;

import com.example.shoppingCart.entity.Product;

public interface ProductService {

	

	Product getProductById(int productid);

	Product getProductByName(String productname);

	List<Product> getProductByCategory(String productcategory);

	
}
