package com.somosbooking.somosBack.service;

import com.somosbooking.somosBack.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.client=?1")
    public Optional<Cart> findByUserId(int userId);
}
