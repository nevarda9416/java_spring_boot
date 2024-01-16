package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.services.SellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class SellingPlaceController {
    @Autowired
    private SellingPlaceService sellingPlaceService;

    @GetMapping("/selling_places")
    public String index(Model model) {
        List<SellingPlaceDTO> sellingPlaces = sellingPlaceService.getAll();
        model.addAttribute("sellingPlaces", sellingPlaces);
        return "admin/selling_place/index";
    }
}
