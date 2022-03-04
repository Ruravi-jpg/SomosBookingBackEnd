package com.somosbooking.somosBack.service;


import com.somosbooking.somosBack.model.Cart;
import com.somosbooking.somosBack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;


    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Cart getCartOfUser(int userId) {
        System.out.println("kk");
        Optional<User> u = null;
        try {
             u = userRepository.findById(userId);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        if(u.isPresent()){
            Optional<Cart> c = cartRepository.findByUserId(u.get().getUserId());

            if(c.isPresent()){
                return c.get();
            }


        }
        return null;
    }

    public void generateCar(int userId, Cart cart) {
        Optional<User> u = userRepository.findById(userId);

        if(u.isPresent()){
            cart.setIdClient(u.get());
            System.out.println(cart.getIdClient().toString());
            cartRepository.save(cart);
        }
    }
}
