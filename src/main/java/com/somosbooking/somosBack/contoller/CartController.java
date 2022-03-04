package com.somosbooking.somosBack.contoller;


import com.somosbooking.somosBack.model.Cart;
import com.somosbooking.somosBack.model.User;
import com.somosbooking.somosBack.service.CartRepository;
import com.somosbooking.somosBack.service.CartService;
import com.somosbooking.somosBack.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart/")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class CartController {
private final CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }




    @GetMapping(path = "{idUsuario}")
    public Cart getUser(@PathVariable("idUsuario") int userId) {
        return cartService.getCartOfUser(userId);
    }

    @PostMapping
    public void generateCart(@RequestParam int userId, @RequestBody Cart cart){
        cartService.generateCar(userId, cart);
    }
}
