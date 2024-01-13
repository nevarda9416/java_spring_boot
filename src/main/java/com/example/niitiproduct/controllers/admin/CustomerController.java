package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CustomerDTO;
import com.example.niitiproduct.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String index(Model model) {
        List<CustomerDTO> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "admin/customer/index";
    }
}