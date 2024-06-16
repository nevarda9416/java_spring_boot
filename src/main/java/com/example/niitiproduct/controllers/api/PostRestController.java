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
@RequestMapping("/api/posts")
public class PostRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity<Object> index() {
        return postService.getAllPosts();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getPostsByCategoryId(@PathVariable("id") Integer categoryId) {
        logger.info("Posts list fetched by category");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(postService.getPostsByCategoryId(categoryId).getBody()));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<Object> getPostBySlug(@PathVariable("slug") String slug) {
        logger.info("Post detail by slug");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(postService.getPostBySlug(slug).getBody()));
    }
}