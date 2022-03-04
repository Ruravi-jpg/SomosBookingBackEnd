package com.somosbooking.somosBack.contoller;

import java.util.List;

import com.somosbooking.somosBack.jwt.config.JwtFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.somosbooking.somosBack.model.User;
import com.somosbooking.somosBack.service.UserService;

@RestController
@RequestMapping(path = "/api/user/")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
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

	@GetMapping(path="type/{token}")
	public Object getUserTypeFromToken(@PathVariable("token") String token){
		return getAllClaimsFromToken(token).get("role");
	}

	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(JwtFilter.secret)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			//LOGGER.error("Could not get all claims Token from passed token");
			claims = null;
		}
		return claims;
	}
}
