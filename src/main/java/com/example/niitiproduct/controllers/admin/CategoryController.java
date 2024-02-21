package com.example.niitiproduct.controllers.admin;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.forms.CategoryData;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Value("${upload.path}category\\")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO());
        return "admin/category/index";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        if (keyword.isEmpty()) {
            List<CategoryDTO> categories = categoryService.getAll();
            model.addAttribute("categories", categories);
        } else {
            List<Category> categories = categoryService.searchByName(keyword);
            model.addAttribute("keyword", keyword);
            model.addAttribute("categories", categories);
        }
        model.addAttribute("category", new CategoryDTO());
        return "admin/category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
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
            FileCopyUtils.copy(categoryData.getImage().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        category.setName(categoryData.getName());
        category.setSummary(categoryData.getSummary());
        category.setDescription(categoryData.getDescription());
        category.setDisplay_order(categoryData.getDisplay_order());
        category.setIs_actived(categoryData.getIs_actived());
        category.setImage(fileName);
        category.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        category.setCreated_by("admin");
        category.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        category.setUpdated_by("admin");
        categoryService.store(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id) {
        categoryService.delete(id);
        List<CategoryDTO> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO());
        return "redirect:/admin/categories";
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> categories = categoryService.getAll();
        System.out.println("Danh mục sản phẩm: " + categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
