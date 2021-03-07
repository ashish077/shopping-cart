package com.example.shoppingCart.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
@PrimaryKeyJoinColumn(name="P_product_id")
public class Book extends Product  {
	private static final long serialVersionUID = 1L;
    
	@Column(name="Author")
	private String author;

	@Column(name="Genre")
	private String genre;

	@Column(name="Publication")
	private String publication;

	
	public Book() {
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}



}