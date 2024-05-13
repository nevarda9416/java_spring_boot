package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.config.constants.Pagination;
import com.example.niitiproduct.dto.PageDTO;
import com.example.niitiproduct.models.Pages;
import com.example.niitiproduct.services.Page.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/pages")
public class PageController {
    @Autowired
    private IPageService pageService;

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String keyword,
                        @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                        @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ){
        if (keyword == null) {
            Page<Pages> pagesPage = pageService.findPaginated(page, size);
            model.addAttribute("keyword", "");
            List<Pages> pages = pagesPage.getContent();
            model.addAttribute("pages", pages);
            model.addAttribute("totalPages", pagesPage.getTotalPages());
            model.addAttribute("totalItems", pagesPage.getTotalElements());
        } else {
            Page<Pages> pagesPage = pageService.searchByName(keyword, page, size);
            model.addAttribute("keyword", keyword);
            List<Pages> pages = pagesPage.getContent();
            model.addAttribute("pages", pages);
            model.addAttribute("totalPages", pagesPage.getTotalPages());
            model.addAttribute("totalItems", pagesPage.getTotalElements());
        }
        model.addAttribute("currentPage", page);
        return "admin/pages/index";
    }

    /**
     * Edit post
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id,
                       @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                       @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        Page<Pages> pagesPage = pageService.findPaginated(page, size);
        model.addAttribute("keyword", "");
        List<Pages> pages = pagesPage.getContent();
        model.addAttribute("pages", pages);
        model.addAttribute("totalPages", pagesPage.getTotalPages());
        model.addAttribute("totalItems", pagesPage.getTotalElements());
        model.addAttribute("currentPage", page);
        Pages pages1 = pageService.findById(id);
        model.addAttribute("page", pages1);
        return "admin/pages/form";
    }

    /**
     * Update post
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Pages page) {
        pageService.save(page);
        return "redirect:/admin/pages/edit/" + page.getId();
    }

    /**
     * Add post
     */
    @GetMapping("/add")
    public String add(Model model, @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                      @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        Page<Pages> pagesPage = pageService.findPaginated(page, size);
        model.addAttribute("keyword", "");
        List<Pages> pages = pagesPage.getContent();
        model.addAttribute("pages", pages);
        model.addAttribute("totalPages", pagesPage.getTotalPages());
        model.addAttribute("totalItems", pagesPage.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("page", new PageDTO());
        return "admin/pages/add";
    }

    /**
     * Insert post
     */
    @PostMapping(value = "/store")
    public String store(@ModelAttribute Pages page) {
        pageService.save(page);
        return "redirect:/admin/pages";
    }

    /**
     * Delete post
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id,
                         @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                         @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ) {
        pageService.delete(id);
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<PageDTO> pages = pageService.getAll(pageable);
        model.addAttribute("pages", pages);
        model.addAttribute("page", new PageDTO());
        return "redirect:/admin/pages";
    }
}

