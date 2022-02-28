package com.somosbooking.somosBack.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somosbooking.somosBack.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
