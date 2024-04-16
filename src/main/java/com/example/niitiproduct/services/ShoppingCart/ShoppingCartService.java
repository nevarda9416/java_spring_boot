package com.example.niitiproduct.services.ShoppingCart;

import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.models.ShoppingCart;
import com.example.niitiproduct.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public boolean store(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return true;
    }

    public ResponseEntity<Object> getShoppingCart() {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        return new ResponseEntity<>(shoppingCartList, HttpStatus.OK);
    }
}
