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
import com.example.shoppingCart.entity.Apparal;
import com.example.shoppingCart.entity.Book;
import com.example.shoppingCart.entity.Product;
import com.example.shoppingCart.repository.apparalRepository;
import com.example.shoppingCart.repository.bookRepository;
import com.example.shoppingCart.repository.productRepository;

@Transactional
@Service
public  class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	productRepository productrepo;
	
	@Autowired
	bookRepository bookrepo;
	
	@Autowired
	apparalRepository apparalrepo;
	
	private static final Logger log = LoggerFactory.getLogger(cartController.class);

	
	@Override
	public Product getProductById(int productid) {
		// TODO Auto-generated method stub
		log.info("return the product with productid: " +productid);
		
		Product product=new Product();
		try {
		
			 product = productrepo.findById(productid).get();
			if (product==null)
			{
				throw new NoSuchElementException();
			}
		}catch (NoSuchElementException ex) {
			// TODO Auto-generated catch block
			log.error("Product with Product-id:" + productid + "NOT FOUND", ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
			"Product with Product-id:" + productid + "NOT FOUND", ex);
		}
		 catch (Exception ex) {
				// TODO Auto-generated catch block
				log.error("Request not processed", ex);
				ex.printStackTrace();
			}
	
		return product;
	}


	@Override
	public Product getProductByName(String productname) {
		// TODO Auto-generated method stub
		log.info("return the product with productname: " +productname);

		Product product=new Product();
		try {
			product=productrepo.getProductbyproductName(productname);
			if(product==null)
			{
				throw new NoSuchElementException();
			}
		}catch (NoSuchElementException ex) {
			// TODO Auto-generated catch block
			log.error("Product with Product-name:" + productname + "NOT FOUND", ex);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
			"Product with Product-name:" + productname + "NOT FOUND", ex);
		}
		 catch (Exception ex) {
				// TODO Auto-generated catch block
				log.error("Request not processed", ex);
				ex.printStackTrace();
			}
		return product;
		
	}


	@Override
	public List<Product> getProductByCategory(String productcategory) {
		// TODO Auto-generated method stub
		log.info("return a list of products based on category");
		List<Product> products=new ArrayList<>();
		if(productcategory.equalsIgnoreCase("Book"))
		{
			List<Book> books=bookrepo.findAll();
			for(Book book:books)
			{
				int productId=book.getProductId();
				Product product=productrepo.getOne(productId);
				products.add(product);
			}
			
		}
		else if(productcategory.equalsIgnoreCase("Apparal"))
		{
			List<Apparal> apparals=apparalrepo.findAll();
			for(Apparal apparal: apparals)
				{
				int productId=apparal.getProductId();
				Product product=productrepo.getOne(productId);
				products.add(product);
			    }
		}
		return products;
	}
	
	

}
