package com.somosbooking.somosBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somosbooking.somosBack.model.User;


@Service
public class UserService {
	
	private final UserRepository userRep;
	
	
	
	@Autowired
	public UserService(UserRepository userRep){
		this.userRep = userRep;
	}
	
	public List<User> getUsers(){
		return userRep.findAll();
	}

	public User getUser(Long userId) {
		return userRep.findById(userId).orElseThrow(() -> new IllegalStateException("el usuario con id " + userId + " No existe"));
	}





}
