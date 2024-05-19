package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.models.User;
import com.example.niitiproduct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Get all users
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/users/index";
    }

    /**
     * Search by user name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<UserDTO> users = userService.getAll();
            model.addAttribute("users", users);
        } else {
            List<User> users = userService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("users", users);
        }
        model.addAttribute("user", new UserDTO());
        return "admin/users/index";
    }

    /**
     * Edit user
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/users/edit";
    }

    /**
     * Update user
     * @param user
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users/edit/" + user.getId();
    }

    /**
     * Add user
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("user", new UserDTO());
        return "admin/users/add";
    }

    /**
     * Insert user
     * @param user
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }

    /**
     * Delete user
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        userService.delete(id);
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        model.addAttribute("user", new UserDTO());
        return "redirect:/admin/categories";
    }
}
