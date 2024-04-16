package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.models.ShoppingCart;
import com.example.niitiproduct.services.ShoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/cart")
    public boolean addCart(@ModelAttribute ShoppingCart shoppingCartData) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setIdentifier(shoppingCartData.getIdentifier());
        shoppingCart.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        shoppingCart.setCreated_by("admin");
        shoppingCart.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        shoppingCart.setUpdated_by("admin");
        return shoppingCartService.store(shoppingCart);
    }

    @GetMapping("/cart")
    public ResponseEntity<Object> getCart() {
        return shoppingCartService.getShoppingCart();
    }
}
