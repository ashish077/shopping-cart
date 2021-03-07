package com.example.shoppingCart.service;

import java.util.List;

import com.example.shoppingCart.entity.Cart;
import com.example.shoppingCart.entity.Product;

public interface CartService {


	Cart viewCart(int cartid);

	void deleteProduct(int cartid, int productid);

	void deleteCart(int userid);

	
	void addCart(int userid, int productid);
}
