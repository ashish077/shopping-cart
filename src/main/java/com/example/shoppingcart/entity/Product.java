package com.example.shoppingCart.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="Price")
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	

	
	//bi-directional many-to-one association to Cart
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="cart_id")
	private Cart cart;

	public Product() {
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + "productName=" + productName
				+ ", price=" + price + ", quantity=" + quantity + ", cart=" + cart + "]";
	}

	public Product(int productId, double mrpPrice, String productName, double price, int quantity, Cart cart) {
		super();
		this.productId = productId;
		
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}