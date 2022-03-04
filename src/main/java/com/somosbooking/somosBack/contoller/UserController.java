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
@CrossOrigin(origins = "http://127.0.0.1:5501/")
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
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}


	@PostMapping
	@ResponseBody
	public String addUser(@RequestBody User user){
		return userService.addUser(user);
	}

	@GetMapping(path="type/{token}")
	public Object getUserTypeFromToken(@PathVariable("token") String token){
		return getObjectFromClaim(token, "role");
	}

	@GetMapping(path="id/{token}")
	public Object getUserIdFromToken(@PathVariable("token") String token){
		return getObjectFromClaim(token, "idUser");
	}

	private Object getObjectFromClaim(String token, String claimName) {
		Object res;
		try {
			res = Jwts.parser()
					.setSigningKey(JwtFilter.secret)
					.parseClaimsJws(token)
					.getBody().get(claimName);
		} catch (Exception e) {
			//LOGGER.error("Could not get all claims Token from passed token");
			res = null;
		}
		return res;
	}
}
