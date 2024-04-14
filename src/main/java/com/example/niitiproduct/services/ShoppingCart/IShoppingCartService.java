package com.example.niitiproduct.services.ShoppingCart;

import org.springframework.http.ResponseEntity;

public interface IShoppingCartService {
    public boolean addShoppingCart();

    public ResponseEntity<Object> getShoppingCart();
}
