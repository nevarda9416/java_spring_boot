package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/comments")
    public String index(Model model) {
        List<CommentDTO> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new CommentDTO());
        return "admin/comment/index";
    }
}