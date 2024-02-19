package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.SettingDTO;
import com.example.niitiproduct.models.Setting;
import com.example.niitiproduct.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("admin/settings")
public class SettingController {
    @Autowired
    private SettingService settingService;

    /**
     * Get all settings
     */
    @GetMapping("")
    public String index(Model model) {
        List<SettingDTO> settings = settingService.getAll();
        model.addAttribute("settings", settings);
        return "admin/setting/index";
    }

    /**
     * Edit setting
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<SettingDTO> settings = settingService.getAll();
        model.addAttribute("settings", settings);
        return "admin/setting/index";
    }

    /**
     * Update setting
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Setting setting) {
        settingService.save(setting);
        return "redirect:/admin/settings/edit/" + setting.getId();
    }

    /**
     * Add setting
     */
    @GetMapping("/settings/add")
    public String add(Model model) {
        List<SettingDTO> settings = settingService.getAll();
        model.addAttribute("settings", settings);
        return "admin/setting/add";
    }

    /**
     * Insert setting
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Setting setting) {
        settingService.save(setting);
        return "redirect:/admin/settings";
    }

    /**
     * Delete setting
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id) {
        settingService.delete(id);
        List<SettingDTO> settings = settingService.getAll();
        model.addAttribute("settings", settings);
        model.addAttribute("setting", new SettingDTO());
        return "redirect:/admin/settings";
    }
}
