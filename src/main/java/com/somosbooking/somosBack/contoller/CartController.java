package com.somosbooking.somosBack.contoller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart/")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class CartController {
}
