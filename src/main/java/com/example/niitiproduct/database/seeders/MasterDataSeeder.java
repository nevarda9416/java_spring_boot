package com.example.niitiproduct.database.seeders;

import com.example.niitiproduct.models.Banner;
import com.example.niitiproduct.models.Category;
import com.example.niitiproduct.models.Customer;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.repositories.BannerRepository;
import com.example.niitiproduct.repositories.CategoryRepository;
import com.example.niitiproduct.repositories.CustomerRepository;
import com.example.niitiproduct.repositories.SubCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BannerRepository bannerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void truncateAllTables() {
        // The jdbcTemplate is another component of Spring Data that provides a high-level way to interact with databases over JDBC.
        // We can use exposed methods to execute our custom queries.
        String sql1 = "TRUNCATE TABLE banners";
        String sql2 = "TRUNCATE TABLE categories";
        String sql3 = "TRUNCATE TABLE customers";
        String sql4 = "TRUNCATE TABLE subcategories";
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
        jdbcTemplate.execute(sql3);
        jdbcTemplate.execute(sql4);
    }

    public void insertBannerData() {
        Banner b1 = new Banner(1, "Banner trang chủ", "Banner trang chủ", "/images/banner/b001.png", "/", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Banner b2 = new Banner(2, "Banner trang danh mục", "Banner trang danh mục", "/images/banner/b002.png", "/", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Banner b3 = new Banner(3, "Banner trang sản phẩm", "Banner trang sản phẩm", "/images/banner/b003.png", "/", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Banner> banners = Arrays.asList(b1, b2, b3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        bannerRepository.saveAll(banners);
    }

    public void insertCategoryData() {
        Category c1 = new Category(1, "Thiết bị mạng khuyến mãi", "/images/category/c001.png", "Thiết bị mạng khuyến mãi", "Thiết bị mạng khuyến mãi", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c2 = new Category(2, "Bộ phát wifi", "/images/category/c002.png", "Bộ phát wifi", "Bộ phát wifi", 2, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c5 = new Category(3, "Bộ mở rộng sóng", "/images/category/c005.png", "Bộ mở rộng sóng", "Bộ mở rộng sóng", 5, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Category> categories = Arrays.asList(c1, c2, c5);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        categoryRepository.saveAll(categories);
    }

    public void insertCustomerData() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Customer c1 = new Customer(1, "nguyenvana@gmail.com", bCryptPasswordEncoder.encode("12345678"), 1, "Nguyễn Văn", "A", "01/01/1990", "Nam", "0987654321", "Hà Nội", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Customer c2 = new Customer(2, "nguyenvanb@gmail.com", bCryptPasswordEncoder.encode("12345678"), 1, "Nguyễn Văn", "B", "01/01/1991", "Nam", "0987654321", "Hà Nội", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Customer c3 = new Customer(3, "nguyenvanc@gmail.com", bCryptPasswordEncoder.encode("12345678"), 1, "Nguyễn Văn", "C", "01/01/1992", "Nam", "0987654321", "Hà Nội", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Customer> customers = Arrays.asList(c1, c2, c3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        customerRepository.saveAll(customers);
    }

    public void insertSubCategoryData() {
        SubCategory s2 = new SubCategory(1, "Bộ phát wifi", "/images/category/c002.png", "Bộ phát wifi", "Bộ phát wifi", 2, 1, 2, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SubCategory s3 = new SubCategory(2, "Bộ phát wifi 4G", "/images/category/c003.png", "Bộ phát wifi 4G", "Bộ phát wifi 4G", 3, 1, 2, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SubCategory s4 = new SubCategory(3, "Wi-Fi công nghệ Mesh", "/images/category/c004.png", "Wi-Fi công nghệ Mesh", "Wi-Fi công nghệ Mesh", 4, 1, 3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<SubCategory> subCategories = Arrays.asList(s2, s3, s4);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        subCategoryRepository.saveAll(subCategories);
    }

    /**
     * Run insert master data
     */
    @GetMapping("")
    public ResponseEntity<Object> insertMasterData() {
        this.truncateAllTables();
        this.insertBannerData();
        this.insertCategoryData();
        this.insertCustomerData();
        this.insertSubCategoryData();
        return new ResponseEntity<>(
                "Đã thêm dữ liệu quảng cáo.<br/>" +
                "Đã thêm dữ liệu danh mục cha.<br/>" +
                "Đã thêm dữ liệu khách hàng.<br/>" +
                "Đã thêm dữ liệu danh mục con."
                , HttpStatus.OK);
    }
}
