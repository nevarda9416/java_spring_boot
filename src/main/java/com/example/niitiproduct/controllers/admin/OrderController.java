package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.OrderDTO;
import com.example.niitiproduct.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public String index(Model model) {
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        model.addAttribute("order", new OrderDTO());
        return "admin/order/index";
    }
}