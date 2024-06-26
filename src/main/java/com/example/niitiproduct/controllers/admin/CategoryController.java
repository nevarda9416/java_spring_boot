package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.config.constants.Pagination;
import com.example.niitiproduct.forms.CategoryData;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.services.Category.CategoryService;
import com.example.niitiproduct.services.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Value("${upload.path}\\category\\")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "search", required = false) String keyword,
                        @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                        @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ){
        if (keyword == null) {
            Page<Category> categoryPage = categoryService.findPaginated(page, size);
            model.addAttribute("keyword", "");
            List<Category> categories = categoryPage.getContent();
            model.addAttribute("categories", categories);
            model.addAttribute("totalPages", categoryPage.getTotalPages());
            model.addAttribute("totalItems", categoryPage.getTotalElements());
        } else {
            Page<Category> categoryPage = categoryService.searchByName(keyword, page, size);
            model.addAttribute("keyword", keyword);
            List<Category> categories = categoryPage.getContent();
            model.addAttribute("categories", categories);
            model.addAttribute("totalPages", categoryPage.getTotalPages());
            model.addAttribute("totalItems", categoryPage.getTotalElements());
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("category", new CategoryDTO());
        return "admin/category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id,
                       @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                       @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size) {
        Page<Category> categoryPage = categoryService.findPaginated(page, size);
        model.addAttribute("keyword", "");
        List<Category> categories = categoryPage.getContent();
        model.addAttribute("categories", categories);
        model.addAttribute("totalPages", categoryPage.getTotalPages());
        model.addAttribute("totalItems", categoryPage.getTotalElements());
        model.addAttribute("currentPage", page);
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/form";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories/edit/" + category.getId();
    }

    @RequestMapping(path = "/store", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String store(@ModelAttribute CategoryData categoryData) throws IOException {
        Category category = new Category();
        MultipartFile multipartFile = categoryData.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            System.out.println(this.fileUpload + fileName);
            FileCopyUtils.copy(categoryData.getImage().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        category.setName(categoryData.getName());
        category.setSlug(categoryData.getSlug());
        category.setSummary(categoryData.getSummary());
        category.setDescription(categoryData.getDescription());
        category.setDisplay_order(categoryData.getDisplay_order());
        category.setIs_actived(categoryData.getIs_actived());
        category.setImage("/images/category/" + fileName);
        category.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        category.setCreated_by("admin");
        category.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        category.setUpdated_by("admin");
        categoryService.store(category);
        return "redirect:/admin/categories/edit/" + category.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id,
                         @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
                         @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ) {
        categoryService.delete(id);
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO());
        return "redirect:/admin/categories";
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll(
            @RequestParam(name="page", required = false, defaultValue = Pagination.defaultPage) Integer page,
            @RequestParam(name="size", required = false, defaultValue = Pagination.defaultSize) Integer size
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<CategoryDTO> categories = categoryService.getAll(pageable);
        System.out.println("Danh mục sản phẩm: " + categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
