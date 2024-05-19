package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.config.constants.Pagination;
import com.example.niitiproduct.forms.SubCategoryData;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.services.Category.CategoryService;
import com.example.niitiproduct.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("admin/subcategories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @Value("${upload.path}\\subcategory\\")
    private String fileUpload;

    /**
     * Get all sub categories
     *
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model,
                        @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                        @RequestParam(name="page", required = false, defaultValue = Pagination.defaultSize) Integer size
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        model.addAttribute("categories", categories);
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "admin/subcategories/index";
    }

    /**
     * Search by sub category name
     *
     * @param model
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<SubCategoryDTO> subCategories = subCategoryService.getAll();
            model.addAttribute("subCategories", subCategories);
        } else {
            List<SubCategory> subCategories = subCategoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("subCategories", subCategories);
        }
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "admin/subcategories/index";
    }

    /**
     * Edit sub category
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        SubCategory subCategory = subCategoryService.findById(id);
        model.addAttribute("subCategory", subCategory);
        return "admin/subcategories/index";
    }

    /**
     * Update sub category
     *
     * @param subCategory
     * @return
     */
    @PostMapping(value = "/update")
    public String update(@ModelAttribute SubCategory subCategory) {
        subCategoryService.save(subCategory);
        return "redirect:/admin/subcategories/edit/" + subCategory.getId();
    }

    /**
     * Add sub category
     *
     * @param model
     * @return
     */
    @GetMapping("/subCategories/add")
    public String add(Model model) {
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        return "admin/subcategories/add";
    }

    /**
     * Insert sub category
     *
     * @param subCategoryData
     * @return
     */
    @RequestMapping(path = "/store", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String store(@ModelAttribute SubCategoryData subCategoryData) throws IOException {
        SubCategory subCategory = new SubCategory();
        MultipartFile multipartFile = subCategoryData.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(subCategoryData.getImage().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        subCategory.setName(subCategoryData.getName());
        subCategory.setSummary(subCategoryData.getSummary());
        subCategory.setDescription(subCategoryData.getDescription());
        subCategory.setDisplay_order(subCategoryData.getDisplay_order());
        subCategory.setIs_actived(subCategoryData.getIs_actived());
        subCategory.setImage(fileName);
        subCategory.setCategory_id(subCategoryData.getCategory_id());
        subCategory.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        subCategory.setCreated_by("admin");
        subCategory.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        subCategory.setUpdated_by("admin");
        subCategoryService.store(subCategory);
        return "redirect:/admin/subcategories";
    }

    /**
     * Delete sub category
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        subCategoryService.delete(id);
        List<SubCategoryDTO> subCategories = subCategoryService.getAll();
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("subCategory", new SubCategoryDTO());
        return "redirect:/admin/subcategories";
    }
}