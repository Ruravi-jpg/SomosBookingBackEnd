package com.somosbooking.somosBack.service;

import com.somosbooking.somosBack.model.ProductsCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<ProductsCart, Integer> {

}
