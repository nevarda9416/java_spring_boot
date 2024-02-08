package com.example.niitiproduct.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class DashboardController {

//    @Autowired
//    private static RedisTemplate template;
    @GetMapping("/dashboard")
    public String index(Model model) {
//        template.opsForValue().set("loda", "Academy");
//        System.out.println("Value of key loda: " + template.opsForValue().get("loda"));
        return "admin/dashboard/index";
    }
}
