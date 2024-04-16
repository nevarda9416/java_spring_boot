package com.example.niitiproduct.services.ShoppingCart;

import com.example.niitiproduct.models.ShoppingCart;
import org.springframework.http.ResponseEntity;

public interface IShoppingCartService {
    boolean store(ShoppingCart shoppingCart);

    ResponseEntity<Object> getShoppingCart();
}
