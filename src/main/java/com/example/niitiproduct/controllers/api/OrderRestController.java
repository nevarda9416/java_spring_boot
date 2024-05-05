package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.models.Order;
import com.example.niitiproduct.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<Object> saveOrder(@RequestBody Order order) {
        logger.info("List product details fetched");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(orderService.saveOrder(order)));
    }
}
