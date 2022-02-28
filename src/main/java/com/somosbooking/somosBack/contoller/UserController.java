package com.somosbooking.somosBack.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.somosbooking.somosBack.model.User;
import com.somosbooking.somosBack.service.UserService;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UserController {
	
	private final UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping(path = "{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		return userService.getUser(userId);
	}


	@PostMapping
	public String addUser(@RequestBody User user){
		return userService.addUser(user);
	}
}
