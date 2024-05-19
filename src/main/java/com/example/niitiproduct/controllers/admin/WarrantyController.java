package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.models.Warranty;
import com.example.niitiproduct.services.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/warranties")
public class WarrantyController {
    @Autowired
    private WarrantyService warrantyService;

    /**
     * Get all warranties
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<WarrantyDTO> warranties = warrantyService.getAll();
        model.addAttribute("warranties", warranties);
        return "admin/warranties/index";
    }

    /**
     * Edit warranty
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<WarrantyDTO> warrantys = warrantyService.getAll();
        model.addAttribute("warrantys", warrantys);
        Warranty warranty = warrantyService.findById(id);
        model.addAttribute("warranty", warranty);
        return "admin/warranties/form";
    }

    /**
     * Update warranty
     *
     * @param warranty
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Warranty warranty) {
        warrantyService.save(warranty);
        return "redirect:/admin/warranties/edit/" + warranty.getId();
    }

    /**
     * Add warranty
     *
     * @param model
     * @return
     */
    @GetMapping("/warrantys/add")
    public String add(Model model) {
        List<WarrantyDTO> warrantys = warrantyService.getAll();
        model.addAttribute("warrantys", warrantys);
        return "admin/warranties/add";
    }

    /**
     * Insert warranty
     *
     * @param warranty
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Warranty warranty) {
        warrantyService.save(warranty);
        return "redirect:/admin/warrantys";
    }

    /**
     * Delete warranty
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        warrantyService.delete(id);
        List<WarrantyDTO> warrantys = warrantyService.getAll();
        model.addAttribute("warrantys", warrantys);
        model.addAttribute("warranty", new WarrantyDTO());
        return "redirect:/admin/categories";
    }
}