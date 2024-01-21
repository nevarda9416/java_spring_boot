package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.OrderLogDTO;
import com.example.niitiproduct.services.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class OrderLogController {
    @Autowired
    private OrderLogService orderLogService;
    @GetMapping("/order_logs")
    public String index(Model model) {
        List<OrderLogDTO> orderLogs = orderLogService.getAll();
        model.addAttribute("orderLogs", orderLogs);
        return "admin/order/log/index";
    }
}