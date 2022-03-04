package com.somosbooking.somosBack.contoller;


import com.somosbooking.somosBack.model.ProductsCart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productCart/")
@CrossOrigin(origins = "*")
public class ProductCartController {




    @PostMapping
    public void addProductoCart(@RequestBody ProductsCart productsCart){

    }

}
