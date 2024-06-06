package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.InventoryDTO;
import com.example.niitiproduct.models.Inventory;
import com.example.niitiproduct.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    /**
     * Get all inventories
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<InventoryDTO> inventories = inventoryService.getAll();
        model.addAttribute("inventories", inventories);
        return "admin/inventories/index";
    }

    /**
     * Search by inventory name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<InventoryDTO> inventories = inventoryService.getAll();
            model.addAttribute("inventories", inventories);
        } else {
            List<Inventory> inventories = inventoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("inventories", inventories);
        }
        model.addAttribute("inventory", new InventoryDTO());
        return "admin/inventories/index";
    }

    /**
     * Edit inventory
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<InventoryDTO> inventories = inventoryService.getAll();
        model.addAttribute("inventories", inventories);
        Inventory inventory = inventoryService.findById(id);
        model.addAttribute("inventory", inventory);
        return "admin/inventories/edit";
    }

    /**
     * Update inventory
     * @param inventory
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Inventory inventory) {
        inventoryService.save(inventory);
        return "redirect:/admin/inventories/edit/" + inventory.getId();
    }

    /**
     * Add inventory
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("inventory", new InventoryDTO());
        return "admin/inventories/add";
    }

    /**
     * Insert inventory
     * @param inventory
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Inventory inventory) {
        inventoryService.save(inventory);
        return "redirect:/admin/inventorys";
    }

    /**
     * Delete inventory
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        inventoryService.delete(id);
        List<InventoryDTO> inventories = inventoryService.getAll();
        model.addAttribute("inventories", inventories);
        model.addAttribute("inventory", new InventoryDTO());
        return "redirect:/admin/categories";
    }
}