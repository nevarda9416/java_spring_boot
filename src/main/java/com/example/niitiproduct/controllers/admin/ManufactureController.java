package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.ManufactureDTO;
import com.example.niitiproduct.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    @GetMapping("/manufactures")
    public String index(Model model) {

        List<ManufactureDTO> manufactures = manufactureService.getAll();
        model.addAttribute("manufactures", manufactures);
        return "admin/manufacture/index";
    }
}