package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CommentDTO;
import com.example.niitiproduct.models.Comment;
import com.example.niitiproduct.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * Get all comments
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<CommentDTO> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new CommentDTO());
        return "admin/comment/index";
    }

    /**
     * Search by comment name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<CommentDTO> comments = commentService.getAll();
            model.addAttribute("comments", comments);
        } else {
            List<Comment> comments = commentService.searchByContent(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("comments", comments);
        }
        model.addAttribute("comment", new CommentDTO());
        return "admin/comment/index";
    }

    /**
     * Edit comment
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<CommentDTO> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        Comment comment = commentService.findById(id);
        model.addAttribute("comment", comment);
        return "admin/comment/form";
    }

    /**
     * Update comment
     * @param comment
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/admin/comments/edit/" + comment.getId();
    }

    /**
     * Add comment
     * @param model
     * @return
     */
    @GetMapping("/comments/add")
    public String add(Model model) {
        List<CommentDTO> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        return "admin/comment/add";
    }

    /**
     * Insert comment
     * @param comment
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/admin/comments";
    }

    /**
     * Delete comment
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        commentService.delete(id);
        List<CommentDTO> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new CommentDTO());
        return "redirect:/admin/categories";
    }
}