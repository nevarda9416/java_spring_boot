package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CommentRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/all")
    public ResponseEntity<Object> index() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/product/{id}")
    public ResponseEntity<Object> getCommentsByProductId(@PathVariable("id") Integer productId) {
        logger.info("Comments list fetched by post");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(commentService.getCommentsByProductId(productId).getBody()));
    }
}