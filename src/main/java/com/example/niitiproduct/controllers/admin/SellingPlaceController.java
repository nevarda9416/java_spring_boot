package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.SellingPlaceDTO;
import com.example.niitiproduct.models.SellingPlace;
import com.example.niitiproduct.services.SellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/selling-places")
public class SellingPlaceController {
    @Autowired
    private SellingPlaceService sellingPlaceService;

    /**
     * Get all selling places
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<SellingPlaceDTO> sellingPlaces = sellingPlaceService.getAll();
        model.addAttribute("sellingPlaces", sellingPlaces);
        return "admin/selling-place/index";
    }

    /**
     * Search by sellingPlace name
     *
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<SellingPlaceDTO> sellingPlaces = sellingPlaceService.getAll();
            model.addAttribute("sellingPlaces", sellingPlaces);
        } else {
            List<SellingPlace> sellingPlaces = sellingPlaceService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("sellingPlaces", sellingPlaces);
        }
        model.addAttribute("sellingPlace", new SellingPlaceDTO());
        return "admin/selling-place/index";
    }

    /**
     * Edit sellingPlace
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        SellingPlace sellingPlace = sellingPlaceService.findById(id);
        model.addAttribute("sellingPlace", sellingPlace);
        return "admin/selling-place/edit";
    }

    /**
     * Update sellingPlace
     *
     * @param sellingPlace
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute SellingPlace sellingPlace) {
        sellingPlaceService.save(sellingPlace);
        return "redirect:/admin/selling-places/edit/" + sellingPlace.getId();
    }

    /**
     * Add sellingPlace
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("sellingPlace", new SellingPlaceDTO());
        return "admin/selling-place/add";
    }

    /**
     * Insert sellingPlace
     *
     * @param sellingPlace
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute SellingPlace sellingPlace) {
        sellingPlaceService.save(sellingPlace);
        return "redirect:/admin/selling-places";
    }

    /**
     * Delete sellingPlace
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        sellingPlaceService.delete(id);
        List<SellingPlaceDTO> sellingPlaces = sellingPlaceService.getAll();
        model.addAttribute("sellingPlaces", sellingPlaces);
        model.addAttribute("sellingPlace", new SellingPlaceDTO());
        return "redirect:/admin/selling-places";
    }
}
