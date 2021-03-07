package com.example.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingCart.entity.Book;


@Repository
public interface bookRepository extends JpaRepository<Book,Integer> {

}
