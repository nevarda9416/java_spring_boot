package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.PostDTO;
import com.example.niitiproduct.models.Post;
import com.example.niitiproduct.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("admin/posts")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * Get all posts
     */
    @GetMapping("")
    public String index(Model model) {
        List<PostDTO> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "admin/post/index";
    }

    /**
     * Search by post name
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<PostDTO> posts = postService.getAll();
            model.addAttribute("posts", posts);
        } else {
            List<Post> posts = postService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("posts", posts);
        }
        model.addAttribute("post", new PostDTO());
        return "admin/post/index";
    }

    /**
     * Edit post
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<PostDTO> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "admin/post/index";
    }

    /**
     * Update post
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/admin/posts/edit/" + post.getId();
    }

    /**
     * Add post
     */
    @GetMapping("/posts/add")
    public String add(Model model) {
        List<PostDTO> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "admin/post/add";
    }

    /**
     * Insert post
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/admin/posts";
    }

    /**
     * Delete post
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id) {
        postService.delete(id);
        List<PostDTO> posts = postService.getAll();
        model.addAttribute("posts", posts);
        model.addAttribute("post", new PostDTO());
        return "redirect:/admin/categories";
    }
}
