package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.config.constants.Pagination;
import com.example.niitiproduct.dto.SubscriberDTO;
import com.example.niitiproduct.forms.SubCategoryData;
import com.example.niitiproduct.forms.SubscriberData;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.models.Subscriber;
import com.example.niitiproduct.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/subscribers")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    /**
     * Get all subscribers
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String keyword,
                        @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                        @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ){
        if (keyword == null) {
            Page<Subscriber> subscriberPage = subscriberService.findPaginated(page, size);
            model.addAttribute("keyword", "");
            List<Subscriber> subscribers = subscriberPage.getContent();
            model.addAttribute("subscribers", subscribers);
            model.addAttribute("totalPages", subscriberPage.getTotalPages());
            model.addAttribute("totalItems", subscriberPage.getTotalElements());
        } else {
            Page<Subscriber> subscriberPage = subscriberService.searchByEmail(keyword, page, size);
            model.addAttribute("keyword", keyword);
            List<Subscriber> subscribers = subscriberPage.getContent();
            model.addAttribute("subscribers", subscribers);
            model.addAttribute("totalPages", subscriberPage.getTotalPages());
            model.addAttribute("totalItems", subscriberPage.getTotalElements());
        }
        model.addAttribute("currentPage", page);
        return "admin/subscribers/index";
    }

    /**
     * Edit subscriber
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id,
                       @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                       @RequestParam(name="page", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        Page<Subscriber> subscriberPage = subscriberService.findPaginated(page, size);
        model.addAttribute("keyword", "");
        List<Subscriber> subscribers = subscriberPage.getContent();
        model.addAttribute("subscribers", subscribers);
        model.addAttribute("totalPages", subscriberPage.getTotalPages());
        model.addAttribute("totalItems", subscriberPage.getTotalElements());
        Subscriber subscriber = subscriberService.findById(id);
        model.addAttribute("subscriber", subscriber);
        return "admin/subscribers/form";
    }

    /**
     * Update subscriber
     *
     * @param subscriber
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Subscriber subscriber) {
        subscriberService.save(subscriber);
        return "redirect:/admin/subscribers/edit/" + subscriber.getId();
    }

    /**
     * Add subscriber
     *
     * @param model
     * @return
     */
    @GetMapping("/subCategories/add")
    public String add(Model model,
                       @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                      @RequestParam(name="page", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<SubscriberDTO> subscribers = subscriberService.getAll(pageable);
        model.addAttribute("subscribers", subscribers);
        return "admin/subscribers/add";
    }

    /**
     * Insert subscriber
     *
     * @param subCategoryData
     * @return
     */
    @RequestMapping(path = "/store", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String store(@ModelAttribute SubscriberData subscriberData) throws IOException {
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(subscriberData.getEmail());
        subscriber.setStatus(subscriberData.getStatus());
        subscriber.setToken(subscriberData.getToken());
        subscriber.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        subscriber.setCreated_by("admin");
        subscriber.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        subscriber.setUpdated_by("admin");
        subscriberService.store(subscriber);
        return "redirect:/admin/subscribers";
    }

    /**
     * Delete subscriber
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id,
                         @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                         @RequestParam(name="page", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        subscriberService.delete(id);
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<SubscriberDTO> subscribers = subscriberService.getAll(pageable);
        model.addAttribute("subscribers", subscribers);
        model.addAttribute("subscriber", new SubscriberDTO());
        return "redirect:/admin/subscribers";
    }
}