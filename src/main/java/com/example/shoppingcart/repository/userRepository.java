package com.example.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingCart.entity.User;

@Repository
public interface userRepository extends JpaRepository<User,Integer>{
	
	

}
