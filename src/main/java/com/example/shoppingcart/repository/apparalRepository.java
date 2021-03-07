package com.example.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingCart.entity.Apparal;

@Repository
public interface apparalRepository extends JpaRepository<Apparal,Integer> {

}
