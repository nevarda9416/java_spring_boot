package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.UserDTO;
import com.example.niitiproduct.services.CategoryService;
import com.example.niitiproduct.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String index(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/user/index";
    }
}
