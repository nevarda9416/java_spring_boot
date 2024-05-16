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
@RequestMapping("admin")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    /**
     * Get all inventories
     * @param model
     * @return
     */
    @GetMapping("/inventories")
    public String index(Model model) {
        List<InventoryDTO> inventories = inventoryService.getAll();
        model.addAttribute("inventories", inventories);
        return "admin/inventory/index";
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
            List<InventoryDTO> inventorys = inventoryService.getAll();
            model.addAttribute("inventorys", inventorys);
        } else {
            List<Inventory> inventorys = inventoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("inventorys", inventorys);
        }
        model.addAttribute("inventory", new InventoryDTO());
        return "admin/inventory/index";
    }

    /**
     * Edit inventory
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<InventoryDTO> inventorys = inventoryService.getAll();
        model.addAttribute("inventorys", inventorys);
        Inventory inventory = inventoryService.findById(id);
        model.addAttribute("inventory", inventory);
        return "edit";
    }

    /**
     * Update inventory
     * @param inventory
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Inventory inventory) {
        inventoryService.save(inventory);
        return "redirect:/admin/inventorys/edit/" + inventory.getId();
    }

    /**
     * Add inventory
     * @param model
     * @return
     */
    @GetMapping("/inventorys/add")
    public String add(Model model) {
        List<InventoryDTO> inventorys = inventoryService.getAll();
        model.addAttribute("inventorys", inventorys);
        return "admin/inventory/add";
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
        List<InventoryDTO> inventorys = inventoryService.getAll();
        model.addAttribute("inventorys", inventorys);
        model.addAttribute("inventory", new InventoryDTO());
        return "redirect:/admin/categories";
    }
}