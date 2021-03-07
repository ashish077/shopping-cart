package com.example.shoppingCart.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Table(name="Cart")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id")
	private int cartId;

	
	@Column(name="total_price")
	private double totalPrice;
	
	@JsonIgnore
	@JoinColumn(name="user_id")
	@OneToOne
	private User user;

	//bi-directional many-to-one association to Product
	@OneToMany(cascade=CascadeType.ALL   )
	private List<Product> product=new ArrayList<Product>();

	public Cart() {
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public Cart(int cartId, int productId, int userId, int totalQuantity, List<Product> products) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.product = product;
	}


	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + ", product=" + product + "]";
	}

	public void setTotalPrice(double totalprice) {
		this.totalPrice = totalprice;
	}

	public void addProduct(Product product) {
		
		List<Product> products =getProduct();
		products.add(product);
		this.setProduct(products);

		
	}

public Product removeProduct(Product product) {
		getProduct().remove(product);
		product.setCart(null);

		return product;
	}
	
	
}