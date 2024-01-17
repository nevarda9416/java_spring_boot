package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.services.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class WarrantyController {
    @Autowired
    private WarrantyService warrantyService;
    @GetMapping("/warranties")
    public String index(Model model) {
        List<WarrantyDTO> warranties = warrantyService.getAll();
        model.addAttribute("warranties", warranties);
        return "admin/warranty/index";
    }
}