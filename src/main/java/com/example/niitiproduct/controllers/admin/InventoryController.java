package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.InventoryDTO;
import com.example.niitiproduct.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/inventories")
    public String index(Model model) {
        List<InventoryDTO> inventories = inventoryService.getAll();
        model.addAttribute("inventories", inventories);
        return "admin/inventory/index";
    }
}