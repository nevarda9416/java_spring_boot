package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.ManufactureDTO;
import com.example.niitiproduct.models.Manufacture;
import com.example.niitiproduct.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/manufactures")
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    /**
     * Get all  manufactures
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        List<ManufactureDTO> manufactures = manufactureService.getAll();
        model.addAttribute("manufactures", manufactures);
        return "admin/manufacture/index";
    }

    /**
     * Search by  manufacture name
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<ManufactureDTO>  manufactures = manufactureService.getAll();
            model.addAttribute(" manufactures",  manufactures);
        } else {
            List<Manufacture>  manufactures = manufactureService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute(" manufactures",  manufactures);
        }
        model.addAttribute(" manufacture", new ManufactureDTO());
        return "admin/ manufacture/index";
    }

    /**
     * Edit  manufacture
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<ManufactureDTO>  manufactures = manufactureService.getAll();
        model.addAttribute(" manufactures",  manufactures);
        Manufacture  manufacture = manufactureService.findById(id);
        model.addAttribute(" manufacture",  manufacture);
        return "admin/ manufacture/form";
    }

    /**
     * Update  manufacture
     * @param  manufacture
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Manufacture  manufacture) {
        manufactureService.save( manufacture);
        return "redirect:/admin/ manufactures/edit/" +  manufacture.getId();
    }

    /**
     * Add  manufacture
     * @param model
     * @return
     */
    @GetMapping("/ manufactures/add")
    public String add(Model model) {
        List<ManufactureDTO>  manufactures = manufactureService.getAll();
        model.addAttribute(" manufactures",  manufactures);
        return "admin/ manufacture/add";
    }

    /**
     * Insert  manufacture
     * @param  manufacture
     * @return
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Manufacture  manufacture) {
        manufactureService.save( manufacture);
        return "redirect:/admin/ manufactures";
    }

    /**
     * Delete  manufacture
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        manufactureService.delete(id);
        List<ManufactureDTO>  manufactures = manufactureService.getAll();
        model.addAttribute(" manufactures",  manufactures);
        model.addAttribute(" manufacture", new ManufactureDTO());
        return "redirect:/admin/categories";
    }
}