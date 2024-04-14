package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.models.ShoppingCart;
import com.example.niitiproduct.services.ShoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/cart")
    public boolean addCart(@ModelAttribute ShoppingCart shoppingCart) {
        return shoppingCartService.addShoppingCart();
    }

    @GetMapping("/cart")
    public ResponseEntity<Object> getCart() {
        return shoppingCartService.getShoppingCart();
    }
}
