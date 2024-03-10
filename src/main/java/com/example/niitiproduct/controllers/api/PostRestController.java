package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts/all")
    public ResponseEntity<Object> index() {
        return postService.getAllPosts();
    }
}