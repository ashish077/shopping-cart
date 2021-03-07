package com.example.shoppingCart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.shoppingCart.controller.cartController;
import com.example.shoppingCart.entity.Cart;
import com.example.shoppingCart.entity.Product;
import com.example.shoppingCart.entity.User;
import com.example.shoppingCart.repository.cartRepository;
import com.example.shoppingCart.repository.productRepository;
import com.example.shoppingCart.repository.userRepository;

@Transactional
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private productRepository productrep;
	@Autowired
	private cartRepository cartrep;
	
	@Autowired
	private userRepository userrep;

	private static final Logger log = LoggerFactory.getLogger(cartController.class);

	

	@Override
	public Cart viewCart(int cartid) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
        try {
			log.info("view the cart entries for the cartid: " + cartid);
        	cart=cartrep.findById(cartid).get();
        	if(cart==null)
        	{
        		throw new NoSuchElementException();
        	}
        	else
        	{
        		log.info("viewcart service completed");
        		return cart;

        	}
        	
        	
        			    
		} catch (NoSuchElementException ex) {
			// TODO Auto-generated catch block
			log.error("CART-ID:" + cartid + " NOT FOUND", ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
			"CART-ID" + cartid + " NOT FOUND", ex);
		}
        
        catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("Request not processed", ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"CART-ID" + cartid + "NOT FOUND", ex);
		}
        
        
		
	}

	

	@Override
	public void deleteProduct(int cartid, int productid) {
		// TODO Auto-generated method stub
		
		Cart cart=new Cart();
		try {
			cart=cartrep.findById(cartid).get();
			if(cart==null)
			{
				log.error("CART-ID:" + cartid + "NOT FOUND");
				throw new NoSuchElementException();
			}
			List<Product> cartList=new ArrayList<Product>();
		    cartList=cart.getProduct();
		    Product product=productrep.getOne(productid);
		    Product cartProduct=cartList.get(cartList.indexOf(product));
		    if( cartProduct != null)
		    {
		    	int Quantity=cartProduct.getQuantity()-1;
		    	if(Quantity==0)
		    	{
		    		log.info("Quantity of product became zero so removing");
		    		cart.removeProduct(product);
		    	}
		    	else
		    	{
		    	cartProduct.setQuantity(Quantity);
		    	log.info("reducing the quantity of the product");
				cartList.set(cartList.indexOf(product),cartProduct);
				cart.setProduct(cartList);
				
		    	}
		    }
		    else
		    {
		      log.error("There is no product with the productId: " + productid +" in the cart");
	          throw new NoSuchElementException();
	          
	     
		    }
			cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());

		    cartrep.save(cart);
		    log.info("product with productid: "+ productid +" deleted");
			
		} 
		
		catch (NoSuchElementException ex) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
			"CART-ID" + cartid , ex);
		}
		
		catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("Request not processed", ex);
		}
	
		
		
		
		
	}

	@Override
	public void deleteCart(int cartid) {
		// TODO Auto-generated method stub
		
		try {
			cartrep.deleteById(cartid);
			log.info("cart with cartid: " +cartid +" deleted");
		} 	
		
		catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("Request not processed", ex);
		}
	}

	
	@Override
	public void addCart(int userid, int productid) {
		// TODO Auto-generated method stub

		try {
			User user=userrep.getOne(userid);
			if (user==null) {
				throw new NoSuchElementException();
			}
			List<Product> cartList=new ArrayList<Product>();
			Cart cart=user.getCart();
			
			if(cart !=null)
			
			
			{
				log.info("cart already exist");
				cartList=cart.getProduct();
				Product product=productrep.getOne(productid);
				boolean hasProduct=cartList.contains(product);
				if( hasProduct)
				{
					log.info("the product with the product:"+ productid +"exist in cart");
					product.setQuantity(product.getQuantity()+1);
					cartList.set(cartList.indexOf(product),product);
					cart.setProduct(cartList);
					


				}
				else
				{
					log.info("the product with the product:"+ productid +"does-not exist in cart");

					product=productrep.getOne(productid);
							          
					product.setQuantity(1);
					cartList.add(product);
					cart.setProduct(cartList);


				}
				
				cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
				cartrep.save(cart);
				log.info(" product added to the cart with productId: "+ productid);


			}
			else
			{
				log.info("creating a new cart for the user");
				Cart newcart=new Cart();
				newcart.setUser(user);
				user.setCart(newcart);
				List<Product> newList=new ArrayList<Product>();
				Product product=productrep.getOne(productid);
				newcart.setTotalPrice(product.getPrice());
				product.setQuantity(1);
				newList.add(product);
				newcart.setProduct(newList);
	            cartrep.save(newcart);
				log.info(" product added to the cart with productId: "+ productid);

	            userrep.save(user);
	            log.info("added the  cart to the user");
				
			}
		}catch (NoSuchElementException ex) {
			// TODO Auto-generated catch block
			log.error("USER-ID:" + userid + "NOT FOUND", ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
			"USER-ID" + userid + "NOT FOUND", ex);
		} 
		catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("Request not processed", ex);
		}






	}
}

