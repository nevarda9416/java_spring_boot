package com.example.niitiproduct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, String message, Object responseObject) {
        Map<String, Object> map = new HashMap<>();
        map.put("time", new Date());
        try {
            map.put("status", status.value());
            map.put("message", message);
            map.put("data", responseObject);
        } catch (Exception exception) {
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", exception.getMessage());
            map.put("data", null);
        }
        return new ResponseEntity<>(map, status);
    }
}
