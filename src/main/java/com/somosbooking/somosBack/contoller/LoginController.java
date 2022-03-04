package com.somosbooking.somosBack.contoller;


import com.somosbooking.somosBack.jwt.config.JwtFilter;
import com.somosbooking.somosBack.model.Token;
import com.somosbooking.somosBack.model.User;
import com.somosbooking.somosBack.model.UserType;
import com.somosbooking.somosBack.model.article;
import com.somosbooking.somosBack.service.UserRepository;
import com.somosbooking.somosBack.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class LoginController {
    private final UserService userService;
    
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public Token login(@RequestBody User user) throws ServletException {
        String res = "Nombre de usuario o contraseña incorrectos";
        User u = userService.login(user.getUserName(), user.getUserPassword());
        if(u != null){
            Token t = new Token(generateToken(u.getUserName(), u.getUserType(), u.getUserId()));
           // System.out.printf("claim user de token %s", getAllClaimsFromToken(t.getAccessToken()).get("role"));
            return t;
        }

        throw new ServletException("Nombre de usuario o contraseña incorrectos");
    }


    private String generateToken(String userName, UserType usertype, long iduser){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 10);
        return Jwts.builder()
                .setSubject(userName)
                .claim("role", usertype)
                .claim("idUser", iduser)
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
                .compact();
    }


}
