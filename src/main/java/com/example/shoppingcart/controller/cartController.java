package com.example.shoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingCart.entity.Cart;
import com.example.shoppingCart.service.CartService;


@RestController
@RequestMapping("api/v1/shoppingcart")
public class cartController {
	
	private static final Logger log = LoggerFactory.getLogger(cartController.class);
    
	@Autowired
	CartService cartservice;
	
	@GetMapping(value="addcart/{userid}/products/{productid}")
	public void addCart(@PathVariable int userid,@PathVariable int productid ){
	
		log.info("inside addcart service");
	  cartservice.addCart(userid,productid);
	  log.info("addcart service completed");
		
	}
	
	@GetMapping("viewcart/{cartid}")
	public Cart viewCart(@PathVariable int cartid){
		log.info("inside viewcart service");
		Cart cart=cartservice.viewCart(cartid);
		return cart;
		
		
		
		
	}
	
	
	@RequestMapping(value="deleteproduct/{cartid}/product/{productid}",method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int cartid,@PathVariable int productid){
		
		log.info("inside deleteproduct service");
		cartservice.deleteProduct(cartid,productid);
		log.info("deleteproduct service completed");
	
		
		
	}
	
	@RequestMapping(value="deletecart/{cartid}",method=RequestMethod.DELETE)
	public void deleteCart(@PathVariable int cartid){
		log.info("inside deletepart service");
	    	cartservice.deleteCart(cartid);
			log.info("deletecart service completed");

	
		
		
	 }
	
	
	
}
