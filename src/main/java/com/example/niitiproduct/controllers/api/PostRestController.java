package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.PostService;
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
public class PostRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PostService postService;

    @GetMapping("/posts/all")
    public ResponseEntity<Object> index() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/category/{id}")
    public ResponseEntity<Object> getPostsByCategoryId(@PathVariable("id") Integer categoryId) {
        logger.info("Posts list fetched by category");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(postService.getPostsByCategoryId(categoryId).getBody()));
    }
}