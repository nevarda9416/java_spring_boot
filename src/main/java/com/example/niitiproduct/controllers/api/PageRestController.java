package com.example.niitiproduct.controllers.api;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.services.Page.PageService;
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

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/pages")
public class PageRestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PageService pageService;

    @GetMapping("/slug/{slug}")
    public ResponseEntity<Object> getPageBySlug(@PathVariable("slug") String slug) {
        logger.info("Page detail by slug");
        return ResponseHandler.generateResponse(HttpStatus.OK, "Success", Objects.requireNonNull(pageService.getPageBySlug(slug).getBody()));
    }
}