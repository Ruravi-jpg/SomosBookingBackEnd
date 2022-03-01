package com.somosbooking.somosBack.contoller;


import com.somosbooking.somosBack.model.User;
import com.somosbooking.somosBack.service.UserRepository;
import com.somosbooking.somosBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping
    public String login(@RequestBody User user){
        return userService.login(user);
    }
}
