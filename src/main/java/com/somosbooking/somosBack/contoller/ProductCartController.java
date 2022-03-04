package com.somosbooking.somosBack.contoller;


import com.somosbooking.somosBack.model.ProductsCart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productCart/")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class ProductCartController {




    @PostMapping
    public void addProductoCart(@RequestBody ProductsCart productsCart){

    }

}
