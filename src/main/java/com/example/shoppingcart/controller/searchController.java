package com.example.shoppingCart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingCart.entity.Product;
import com.example.shoppingCart.service.CartService;
import com.example.shoppingCart.service.ProductService;

@RestController
@RequestMapping("api/v1/search")
public class searchController {
 
	@Autowired
	CartService cartservice;
	
	@Autowired
	ProductService productservice;
	
	private static final Logger log = LoggerFactory.getLogger(cartController.class);

	@GetMapping("searchid/{productid}")
	public Product searchId(@PathVariable int productid)
	{
		log.info("inside search product by id service");

		Product product=productservice.getProductById(productid);
		log.info(" search product by id service completed");
	
		
		return product;
	}
	
	@GetMapping("searchname/{productname}")
	public Product searchName(@PathVariable String productname)
	{
		log.info("inside search product by name service");

		Product product=productservice.getProductByName(productname);
		log.info(" search product by name service completed");
		
		return product;
	}
	
	@GetMapping("searchcategory/{productcategory}")
	public List<Product> searchCategory(@PathVariable String productcategory)
	{
		log.info("inside search product by category service");

		List<Product> products=productservice.getProductByCategory(productcategory);
		log.info(" search product by category service completed");

		return products;
	}
	
	
}
