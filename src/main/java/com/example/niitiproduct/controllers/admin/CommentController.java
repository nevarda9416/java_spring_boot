package com.example.niitiproduct.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class CommentController {

    @GetMapping("/comments")
    public String index(Model model) {
        return "admin/comment/index";
    }
}