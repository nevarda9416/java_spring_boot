package com.example.niitiproduct.database.seeders;

import com.example.niitiproduct.dto.CategoryDTO;
import com.example.niitiproduct.dto.SettingDTO;
import com.example.niitiproduct.models.Banner;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.repositories.BannerRepository;
import com.example.niitiproduct.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("data/master")
public class MasterDataSeeder {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void truncateAllTables() {
        // The jdbcTemplate is another component of Spring Data that provides a high-level way to interact with databases over JDBC.
        // We can use exposed methods to execute our custom queries.
        String sql1 = "TRUNCATE TABLE categories";
        jdbcTemplate.execute(sql1);
    }

    public void insertCategoryData() {
        Category c1 = new Category(1, "Thiết bị mạng khuyến mãi", "/images/category/c001.png", "Thiết bị mạng khuyến mãi", "Thiết bị mạng khuyến mãi", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c2 = new Category(2, "Bộ phát wifi", "/images/category/c002.png", "Bộ phát wifi", "Bộ phát wifi", 2, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c3 = new Category(3, "Bộ phát wifi 4G", "/images/category/c003.png", "Bộ phát wifi 4G", "Bộ phát wifi 4G", 3, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c4 = new Category(4, "Wi-Fi công nghệ Mesh", "/images/category/c004.png", "Wi-Fi công nghệ Mesh", "Wi-Fi công nghệ Mesh", 4, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c5 = new Category(5, "Bộ mở rộng sóng5", "/images/category/c005.png", "Bộ mở rộng sóng", "Bộ mở rộng sóng", 5, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Category> categories = Arrays.asList(c1, c2, c3, c4, c5);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        categoryRepository.saveAll(categories);
    }

    /**
     * Run insert master data
     */
    @GetMapping("")
    public ResponseEntity<Object> insertMasterData() {
        this.truncateAllTables();
        this.insertCategoryData();
        List<Category> categoryList = categoryRepository.findAll();
        return new ResponseEntity<>("Đã thêm dữ liệu danh mục cha<br/>Đã thêm dữ liệu danh mục con", HttpStatus.OK);
    }
}
