package com.example.niitiproduct.database.seeders;

import com.example.niitiproduct.exceptions.ResponseHandler;
import com.example.niitiproduct.helpers.Csv;
import com.example.niitiproduct.models.*;
import com.example.niitiproduct.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("data/master")
public class MasterDataSeeder {
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ManufactureRepository manufactureRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductInventoryRepository productInventoryRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private SellingPlaceRepository sellingPlaceRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WarrantyRepository warrantyRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void truncateAllTables() {
        // The jdbcTemplate is another component of Spring Data that provides a high-level way to interact with databases over JDBC.
        // We can use exposed methods to execute our custom queries.
        String sql0 = "SET foreign_key_checks = 0";
        String sql1 = "TRUNCATE TABLE banners";
        String sql2 = "TRUNCATE TABLE categories";
        String sql3 = "TRUNCATE TABLE customers";
        String sql4 = "TRUNCATE TABLE comments";
        String sql5 = "TRUNCATE TABLE manufactures";
        String sql6 = "TRUNCATE TABLE inventories";
        String sql7 = "TRUNCATE TABLE orders";
        String sql8 = "TRUNCATE TABLE order_items";
        String sql9 = "TRUNCATE TABLE posts";
        String sql10 = "TRUNCATE TABLE products";
        String sql11 = "TRUNCATE TABLE product_details";
        String sql12 = "TRUNCATE TABLE product_inventories";
        String sql13 = "TRUNCATE TABLE promotions";
        String sql14 = "TRUNCATE TABLE roles";
        String sql15 = "TRUNCATE TABLE shopping_carts";
        String sql16 = "TRUNCATE TABLE subcategories";
        String sql17 = "TRUNCATE TABLE selling_places";
        String sql18 = "TRUNCATE TABLE settings";
        String sql19 = "TRUNCATE TABLE subscribers";
        String sql20 = "TRUNCATE TABLE users";
        String sql21 = "TRUNCATE TABLE warranties";
        String sql22 = "SET foreign_key_checks = 1";
        jdbcTemplate.execute(sql0);
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
        jdbcTemplate.execute(sql3);
        jdbcTemplate.execute(sql4);
        jdbcTemplate.execute(sql5);
        jdbcTemplate.execute(sql6);
        jdbcTemplate.execute(sql7);
        jdbcTemplate.execute(sql8);
        jdbcTemplate.execute(sql9);
        jdbcTemplate.execute(sql10);
        jdbcTemplate.execute(sql11);
        jdbcTemplate.execute(sql12);
        jdbcTemplate.execute(sql13);
        jdbcTemplate.execute(sql14);
        jdbcTemplate.execute(sql15);
        jdbcTemplate.execute(sql16);
        jdbcTemplate.execute(sql17);
        jdbcTemplate.execute(sql18);
        jdbcTemplate.execute(sql19);
        jdbcTemplate.execute(sql20);
        jdbcTemplate.execute(sql21);
        jdbcTemplate.execute(sql22);
    }

    public void insertAttributeData() {
        Attribute a1 = new Attribute(1, "ax", "Chuẩn AX", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Attribute a2 = new Attribute(2, "ax-frequency", "AX3000Mbps", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Attribute a3 = new Attribute(3, "2-antenna", "2 Ăng-ten", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Attribute> attributes = Arrays.asList(a1, a2, a3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        attributeRepository.saveAll(attributes);
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
        Category c1 = new Category(1, "Thiết bị mạng", "thiet-bi-mang", "/images/category/c001.png", "Thiết bị mạng", "Thiết bị mạng khuyến mãi", 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c2 = new Category(2, "Bộ phát wifi", "bo-phat-wifi", "/images/category/c002.png", "Bộ phát wifi", "Bộ phát wifi", 2, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Category c3 = new Category(3, "Bộ mở rộng sóng", "bo-mo-rong-song", "/images/category/c003.png", "Bộ mở rộng sóng", "Bộ mở rộng sóng", 3, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Category> categories = Arrays.asList(c1, c2, c3);
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

    public void insertCommentData() {
        Comment c1 = new Comment(1, 1, "product", "product", "Nguyễn Văn A", "0987654321", "nguyenvana@gmail.com", "Hà Nội", "192.168.172.143", "Google Chrome", "Sản phẩm tốt giá vừa phải", "publish", "2024-02-20 01:02:00", 1, 0, 0, 0, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Comment c2 = new Comment(2, 2, "product", "product", "Nguyễn Văn B", "0987654321", "nguyenvanb@gmail.com", "Hà Nội", "192.168.182.143", "Mozilla Firefox", "Sản phẩm tốt giá thành hơi cao", "publish", "2024-02-20 01:02:00", 1, 0, 0, 0, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Comment c3 = new Comment(3, 3, "product", "product", "Nguyễn Văn C", "0987654321", "nguyenvanc@gmail.com", "Hà Nội", "192.168.192.143", "Internet Explorer", "Sản phẩm phải đổi trả", "waiting_review", "2024-02-20 01:02:00", 1, 0, 0, 0, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Comment> comments = Arrays.asList(c1, c2, c3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        commentRepository.saveAll(comments);
    }

    public void insertInventoryData() {
        Inventory i1 = new Inventory(1, "Kho A", "Hà Nội", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Inventory i2 = new Inventory(2, "Kho B", "Đà Nẵng", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Inventory i3 = new Inventory(3, "Kho C", "Hồ Chí Minh", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Inventory> inventories = Arrays.asList(i1, i2, i3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        inventoryRepository.saveAll(inventories);
    }

    public void insertManufactureData() {
        Manufacture m1 = new Manufacture(1, "Asus ", "Asus", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m2 = new Manufacture(2, "TP-Link ", "TP-Link", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m3 = new Manufacture(3, "Cisco", "Cisco", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m4 = new Manufacture(4, "Linksys", "Linksys", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m5 = new Manufacture(5, "Draytek", "Draytek", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m6 = new Manufacture(6, "TotoLink ", "Totolink", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Manufacture m7 = new Manufacture(7, "Commscope ", "Commscope", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);

        List<Manufacture> manufactures = Arrays.asList(m1, m2, m3, m4, m5, m6, m7);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        manufactureRepository.saveAll(manufactures);
    }

    public void insertOrderData() {
        Order o1 = new Order(1, "20240208TBM1", 2500000F, 2, (float) 0, "Chưa thanh toán", 2500000F,
                "Nhận hàng thanh toán", 1, "Viettel post", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "Đào Văn A", "Duy Tân, Cầu Giấy, Hà Nội", "daovana@gmail.com", 20000F, "0987654321", "01", "Hà Nội", "007", "Quận Hai Bà Trưng", "00244", "Bạch Đằng", "COD", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "", 0F,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Order o2 = new Order(2, "20240209TBM1", 1500000F, 1, (float) 0, "Đã thanh toán", (float) 0,
                "Nhận hàng thanh toán", 1, "Viettel post", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "Đào Văn A", "Duy Tân, Cầu Giấy, Hà Nội", "daovana@gmail.com", 20000F, "0987654321", "01", "Hà Nội", "007", "Quận Hai Bà Trưng", "00244", "Bạch Đằng", "COD", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "", 0F,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Order o3 = new Order(3, "20240309TBM1", 4600000F, 3, (float) 0, "Chưa thanh toán", 4600000F,
                "Nhận hàng thanh toán", 1, "Viettel post", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "Đào Văn A", "Duy Tân, Cầu Giấy, Hà Nội", "daovana@gmail.com", 20000F, "0987654321", "01", "Hà Nội", "007", "Quận Hai Bà Trưng", "00244", "Bạch Đằng", "COD", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "", 0F,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Order> orders = Arrays.asList(o1, o2, o3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        orderRepository.saveAll(orders);
    }

    public void insertOrderItemData() {
        OrderItem o1 = new OrderItem(1, 1, 1, 3, 3500000F, "CODE202401WF", 50000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        OrderItem o2 = new OrderItem(2, 1, 2, 2, 2500000F, "CODE202402WF", 50000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        OrderItem o3 = new OrderItem(3, 1, 3, 1, 1500000F, "CODE202403WF", 50000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<OrderItem> orderItems = Arrays.asList(o1, o2, o3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        orderItemRepository.saveAll(orderItems);
    }

    public void insertPostData() {
        Post p1 = new Post(1, "IMOU Bullet 3C S3EP: camera an ninh ngoài trời 5Mpx, nhận diện người, xe bằng AI", "/review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai.html", "review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai",
                "Camera IMOU BULLET 3C S3EP là dòng camera an ninh ngoài trời, trợ thủ đắc lực giúp bảo vệ ngôi nhà của bạn ở ngoài trời một cách an toàn nhất. Được trang bị ống kính có độ phân giải lên đến 5Mpx (3K), công nghệ an ninh IMOU SENSE sử dụng trí tuệ AI để nhận biết hoạt cảnh một cách chính xác và nhanh chóng nhất, tích hợp đèn LED quay hình ảnh có màu vào ban đêm và rất nhiều các công nghệ xịn sò khác.", "Camera IMOU BULLET 3C S3EP là dòng camera an ninh ngoài trời, trợ thủ đắc lực giúp bảo vệ ngôi nhà của bạn ở ngoài trời một cách an toàn nhất. Được trang bị ống kính có độ phân giải lên đến 5Mpx (3K), công nghệ an ninh IMOU SENSE sử dụng trí tuệ AI để nhận biết hoạt cảnh một cách chính xác và nhanh chóng nhất, tích hợp đèn LED quay hình ảnh có màu vào ban đêm và rất nhiều các công nghệ xịn sò khác.", "Camera IMOU BULLET 3C S3EP là dòng camera an ninh ngoài trời, trợ thủ đắc lực giúp bảo vệ ngôi nhà của bạn ở ngoài trời một cách an toàn nhất. Được trang bị ống kính có độ phân giải lên đến 5Mpx (3K), công nghệ an ninh IMOU SENSE sử dụng trí tuệ AI để nhận biết hoạt cảnh một cách chính xác và nhanh chóng nhất, tích hợp đèn LED quay hình ảnh có màu vào ban đêm và rất nhiều các công nghệ xịn sò khác.",
                "Editor A", 2, "publish", "2024-02-24 01:10:06", 1, 0, "product", 7, 0, 1, "IMOU Bullet 3C S3EP", "IMOU Bullet", "IMOU Bullet 3C S3EP", "/images/post/p001.png", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Post p2 = new Post(2, "Camera Quay Quét Ngoài trời Ezviz C8C 4M: Cải tiến liệu còn NGON", "/review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai.html", "review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai",
                "Camera Ezviz C8C 2K+ (4M) là dòng camera an ninh ngoài trời có khả năng quay quét 360 độ, thích hợp cho người dùng là hộ gia đình hoặc các shop, cửa hàng tiện ích gắn để quan sát khu vực được rộng hơn các camera an ninh thông thường. Đây cũng là phiên bản mới được nâng cấp từ dòng Ezivz C8W ở thế hệ tiền nhiệm.",
                "Camera Ezviz C8C 2K+ (4M) là dòng camera an ninh ngoài trời có khả năng quay quét 360 độ, thích hợp cho người dùng là hộ gia đình hoặc các shop, cửa hàng tiện ích gắn để quan sát khu vực được rộng hơn các camera an ninh thông thường. Đây cũng là phiên bản mới được nâng cấp từ dòng Ezivz C8W ở thế hệ tiền nhiệm.",
                "Camera Ezviz C8C 2K+ (4M) là dòng camera an ninh ngoài trời có khả năng quay quét 360 độ, thích hợp cho người dùng là hộ gia đình hoặc các shop, cửa hàng tiện ích gắn để quan sát khu vực được rộng hơn các camera an ninh thông thường. Đây cũng là phiên bản mới được nâng cấp từ dòng Ezivz C8W ở thế hệ tiền nhiệm.",
                "Editor B", 3, "publish", "2024-02-24 01:10:06", 1, 0, "product", 7, 0, 1, "IMOU Bullet 3C S3EP", "IMOU Bullet", "IMOU Bullet 3C S3EP", "/images/post/p002.png", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Post p3 = new Post(3, "IMOU Cruiser 2 3K GS7EP | Camera không dây ngoài trời tích hợp AI thông minh", "/review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai.html", "review-imou-bullet-3c-s3ep-camera-an-ninh-ngoai-troi-5mpx-nhan-dien-nguoi-xe-bang-ai",
                "Camera iMOU Cruiser 2 3K GS7EP là chiếc camera ngoài trời có độ phân giải lên đến 5mp, xoay 360 độ không góc chết, tích hợp AI cùng công nghệ IMOU SENSE đoạt giải camera AI xuất sắc nhất năm 2023 do camera AI Tech Award 2023 bình chọn. Hãy cùng Phúc Anh kỹ hơn về chiếc camera này xem còn điều gì đặc sắc nhé.",
                "Camera iMOU Cruiser 2 3K GS7EP là chiếc camera ngoài trời có độ phân giải lên đến 5mp, xoay 360 độ không góc chết, tích hợp AI cùng công nghệ IMOU SENSE đoạt giải camera AI xuất sắc nhất năm 2023 do camera AI Tech Award 2023 bình chọn. Hãy cùng Phúc Anh kỹ hơn về chiếc camera này xem còn điều gì đặc sắc nhé.",
                "Camera iMOU Cruiser 2 3K GS7EP là chiếc camera ngoài trời có độ phân giải lên đến 5mp, xoay 360 độ không góc chết, tích hợp AI cùng công nghệ IMOU SENSE đoạt giải camera AI xuất sắc nhất năm 2023 do camera AI Tech Award 2023 bình chọn. Hãy cùng Phúc Anh kỹ hơn về chiếc camera này xem còn điều gì đặc sắc nhé.",
                "Editor C", 4, "publish", "2024-02-24 01:10:06", 1, 0, "product", 7, 0, 1, "IMOU Bullet 3C S3EP", "IMOU Bullet", "IMOU Bullet 3C S3EP", "/images/post/p003.png", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Post> posts = Arrays.asList(p1, p2, p3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        postRepository.saveAll(posts);
    }

    public void insertProductData() {
        Product p1 = new Product(1, "Cạc mạng không dây Asus PCI-E PCE-AX3000 Tray (Chuẩn AX/ AX3000Mbps/ 2 Ăng-ten ngoài)",
                "cac-mang-khong-day-asus-pci-e-pce-ax3000-tray-chuan-ax-ax3000mbps-2-ang-ten-ngoai",
                "<ul class=\"ul\">\n" +
                        "                      \n" +
                        "                <li><i class=\"before\"></i><span><h3>Tốc độ WIFI: AX3000Mbps</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Angten: 2 Ăng-ten ngoài</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Chuẩn kết nối: Chuẩn AX (Wifi 6)</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Chuẩn cắm: PCI-E</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Mô tả khác: PCI-E AX3000 WiFi 6 (802.11ax) băng tần kép. Hỗ trợ 160 MHz, Bluetooth 5.0, bảo mật mạng WPA3, OFDMA và MU-MIMO Tiêu chuẩn Wi-Fi thế hệ mới - Chuẩn WiFi 6 (802.11ax) cho hiệu suất và thông lượng tốt hơn. Tốc độ Wi-Fi siêu nhanh - Tốc độ WiFi 3000Mbps để xử lý ngay cả mạng bận nhất một cách dễ dàng. Công nghệ 802.11ax — Với OFDMA và MU-MIMO, WiFi 6 cho khả năng truyền dữ liệu hiệu quả, ổn định và nhanh hơn, ngay cả khi có nhiều thiết bị cùng truyền dữ liệu một lúc. Bluetooth 5.0 để kết nối nhanh hơn, phủ sóng rộ</h3></span></li>\n" +
                        "                \n" +
                        "                \n" +
                        "                <div id=\"tabtem\"><a href=\"#tab2\" style=\"color: #f00;\">Xem chi tiết</a></div>\n" +
                        "            </ul>",
                "Card mạng không dây Với công nghệ WiFi 6 (802.11ax) và băng thông rộng 160 MHz, ASUS PCE-AX3000 mang đến tốc độ không dây nhanh hơn gấp 2,7 lần so với các thiết bị WiFi 5 (802.11ac). Sự kết hợp mang tính cách mạng giữa công nghệ OFDMA và MU-MIMO đảm bảo kết nối WiFi hiệu quả nhất cho máy tính của bạn.",
                "Card mạng không dây Với công nghệ WiFi 6 (802.11ax) và băng thông rộng 160 MHz, ASUS PCE-AX3000 mang đến tốc độ không dây nhanh hơn gấp 2,7 lần so với các thiết bị WiFi 5 (802.11ac). Sự kết hợp mang tính cách mạng giữa công nghệ OFDMA và MU-MIMO đảm bảo kết nối WiFi hiệu quả nhất cho máy tính của bạn.",
                1, 1, 1, 1, "Cạc mạng không dây Asus PCI-E PCE-AX3000 Tray", "PCI-E,PCE-AX3000,AX3000Mbps", "Cạc mạng không dây Asus PCI-E PCE-AX3000 Tray", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Product p2 = new Product(2, "Bộ phát wifi 6 Asus RT-AX53U (Chuẩn AX/ AX1800Mbps/ 4 Ăng-ten ngoài/ Wifi Mesh/ 35 User)",
                "bo-phat-wifi-6-asus-rt-ax53u-chuan-ax-ax1800mbps-4-ang-ten-ngoai-wifi-mesh-35-user",
                "<ul class=\"ul\">\n" +
                        "                      \n" +
                        "                <li><i class=\"before\"></i><span><h3>Tốc độ WIFI: AX1800Mbps</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Chuẩn kết nối: Chuẩn AX (Wifi 6)</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Angten: 4 Ăng-ten ngoài</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Cổng giao tiếp: 3 port x Giga Lan, 1x Giga Wan, 1 x USb 3.1, RAM 256MB, 128 Flash.</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Tốc độ LAN: 10/100/1000Mbps</h3></span></li>\n" +
                        "                \n" +
                        "                \n" +
                        "                <div id=\"tabtem\"><a href=\"#tab2\" style=\"color: #f00;\">Xem chi tiết</a></div>\n" +
                        "            </ul>",
                "Wi-Fi công nghệ Mesh Asus RT-AX53U chuẩn Wifi 6 (802.11ax) mới nhất cung cấp các công nghệ trong tương lai, hiệu quả mạng cao hơn, tốc độ WiFi nhanh hơn, vùng phủ sóng lớn hơn và thời lượng pin được cải thiện cho các thiết bị được kết nối, mang lại cho người dùng trải nghiệm mạng tốt hơn đáng kể.",
                "Wi-Fi công nghệ Mesh Asus RT-AX53U chuẩn Wifi 6 (802.11ax) mới nhất cung cấp các công nghệ trong tương lai, hiệu quả mạng cao hơn, tốc độ WiFi nhanh hơn, vùng phủ sóng lớn hơn và thời lượng pin được cải thiện cho các thiết bị được kết nối, mang lại cho người dùng trải nghiệm mạng tốt hơn đáng kể.",
                2, 4, 1, 1, "Bộ phát wifi 6 Asus RT-AX53U", "RT-AX53U,AX1800Mbps", "Bộ phát wifi 6 Asus RT-AX53U", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Product p3 = new Product(3, "Bộ phát wifi 6 Asus RT-AX1800HP MU-MIMO (Chuẩn AX/ AX1800Mbps/ 4 Ăng-ten ngoài/ Wifi Mesh/ 35 User)",
                "bo-phat-wifi-6-asus-rt-ax1800hp-mu-mimo-chuan-ax-ax1800mbps-4-ang-ten-ngoai-wifi-mesh-35-user",
                "<ul class=\"ul\">\n" +
                        "                      \n" +
                        "                <li><i class=\"before\"></i><span><h3>Tốc độ WIFI: AX1800Mbps</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Chuẩn kết nối: Chuẩn AX (Wifi 6)</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Angten: 4 Ăng-ten ngoài</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Cổng giao tiếp: RJ45 for Gigabits BaseT for WAN x 1, RJ45 for Gigabits BaseT for LAN x 4</h3></span></li>\n" +
                        "                <li><i class=\"before\"></i><span><h3>Tốc độ LAN: 10/100/1000Mbps</h3></span></li>\n" +
                        "                \n" +
                        "                \n" +
                        "                <div id=\"tabtem\"><a href=\"#tab2\" style=\"color: #f00;\">Xem chi tiết</a></div>\n" +
                        "            </ul>",
                "Ngày càng có nhiều thiết bị cá nhân và thiết bị IoT được kết nối với bộ phát Wifi, dẫn đến sự gia tăng tổng thể về mật độ mạng, đẩy giới hạn của tiêu chuẩn WiFi hiện tại lên mức cao hơn. Chuẩn WiFi 6 (802.11ax) mới nhất cung cấp các công nghệ tương lai, hiệu quả kết nối mạng tốt hơn, tốc độ WiFi nhanh hơn, phạm vi phủ sóng lớn hơn và cải thiện thời lượng pin cho các thiết bị được kết nối, mang lại trải nghiệm mạng tối ưu hơn nhiều cho người dùng.",
                "Ngày càng có nhiều thiết bị cá nhân và thiết bị IoT được kết nối với bộ phát Wifi, dẫn đến sự gia tăng tổng thể về mật độ mạng, đẩy giới hạn của tiêu chuẩn WiFi hiện tại lên mức cao hơn. Chuẩn WiFi 6 (802.11ax) mới nhất cung cấp các công nghệ tương lai, hiệu quả kết nối mạng tốt hơn, tốc độ WiFi nhanh hơn, phạm vi phủ sóng lớn hơn và cải thiện thời lượng pin cho các thiết bị được kết nối, mang lại trải nghiệm mạng tối ưu hơn nhiều cho người dùng.",
                2, 3, 1, 1, "Bộ phát wifi 6 Asus RT-AX1800HP MU-MIMO", "RT-AX1800HP,MU-MIMO,AX1800Mbps", "Bộ phát wifi 6 Asus RT-AX1800HP MU-MIMO", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Product> products = Arrays.asList(p1, p2, p3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        productRepository.saveAll(products);
    }

    public void insertProductDetailData() {
        ProductDetail p1 = new ProductDetail(1, "1,2", 1800000F, 1600000F, 1, "SKUAX001", "/images/product/p001.png", "in_stock", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ProductDetail p2 = new ProductDetail(2, "1,2,3", 1900000F, 1800000F, 2, "SKUAX002", "/images/product/p002.png", "in_stock", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ProductDetail p3 = new ProductDetail(3, "1", 1500000F, 1500000F, 3, "SKUAX003", "/images/product/p003.png", "out_of_stock", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<ProductDetail> productDetails = Arrays.asList(p1, p2, p3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        productDetailRepository.saveAll(productDetails);
    }

    public void insertProductInventoryData() {
        ProductInventory p1 = new ProductInventory(1, 1, 1, 998, 1, 2
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ProductInventory p2 = new ProductInventory(1, 2, 2, 997, 2, 3
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ProductInventory p3 = new ProductInventory(1, 3, 3, 996, 3, 4
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<ProductInventory> productInventories = Arrays.asList(p1, p2, p3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        productInventoryRepository.saveAll(productInventories);
    }

    public void insertPromotionData() {
        Promotion p1 = new Promotion(1, "CODE202401WF", "Khuyến mãi trên sản phẩm", "product", "30000", "", "01/01/2024", "01/01/2025", 1
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Promotion p2 = new Promotion(2, "CODE202402WF", "Khuyến mãi trên đơn hàng", "order", "50000", "", "01/01/2024", "01/01/2025", 1
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Promotion p3 = new Promotion(3, "CODE202403WF", "Khuyến mãi trên khách hàng thân thiết", "vip_1", "10000", "", "01/01/2024", "01/01/2025", 1
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Promotion> promotions = Arrays.asList(p1, p2, p3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        promotionRepository.saveAll(promotions);
    }

    public void insertRoleData() {
        Role r1 = new Role(1, "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Role r2 = new Role(2, "sale", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Role r3 = new Role(3, "shipper", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Role> roles = Arrays.asList(r1, r2, r3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        roleRepository.saveAll(roles);
    }

    public void insertShoppingCartData() {
        ShoppingCart s1 = new ShoppingCart(1, "sc-202403172346-1-pc", "Nhận hàng mới thanh toán", 1, "Viettel Post", "2024-03-30", "Đào Văn A", "Hà Nội", "daovana@gmail.com", "20000", "0987654321", 1, "Hà Nội", 1, "Hai Bà Trưng", 1, "Bạch Đằng", "Giao hàng trong giờ hành chính", "COD", "2024-03-30", "CODE202401WF", 30000F, 150000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ShoppingCart s2 = new ShoppingCart(2, "sc-202403172347-2-pc", "Nhận hàng mới thanh toán", 2, "Viettel Post", "2024-03-30", "Đào Văn B", "Hà Nội", "daovanb@gmail.com", "20000", "0987654321", 1, "Hà Nội", 1, "Hai Bà Trưng", 1, "Bạch Đằng", "Giao hàng trong giờ hành chính", "COD", "2024-03-30", "CODE202401WF", 30000F, 150000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        ShoppingCart s3 = new ShoppingCart(3, "sc-202403172356-3-pc", "Nhận hàng mới thanh toán", 3, "Viettel Post", "2024-03-30", "Đào Văn C", "Hà Nội", "daovanc@gmail.com", "20000", "0987654321", 1, "Hà Nội", 1, "Hai Bà Trưng", 1, "Bạch Đằng", "Giao hàng trong giờ hành chính", "COD", "2024-03-30", "CODE202401WF", 30000F, 150000F, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<ShoppingCart> shoppingCarts = Arrays.asList(s1, s2, s3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        shoppingCartRepository.saveAll(shoppingCarts);
    }

    public void insertSellingPlaceData() {
        SellingPlace s1 = new SellingPlace(1, "SHOWROOM XÃ ĐÀN", "Xã Đàn, Đống Đa, Hà Nội", "Hà Nội", "Đống Đa", "Xã Đàn", "Xã Đàn, Đống Đa, Hà Nội", "(024) 3968 9966 (ext 1)", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SellingPlace s2 = new SellingPlace(2, "SHOWROOM TRẦN DUY HƯNG", "Trần Duy Hưng, Cầu Giấy, Hà Nội", "Hà Nội", "Cầu Giấy", "Trần Duy Hưng", "Trần Duy Hưng, Cầu Giấy, Hà Nội", "(024) 3968 9966 (ext 2)", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SellingPlace s3 = new SellingPlace(3, "SHOWROOM THÁI HÀ", "Thái Hà, Đống Đa, Hà Nội", "Hà Nội", "Đống Đa", "Thái Hà", "Thái Hà, Đống Đa, Hà Nội", "(024) 3968 9966 (ext 3)", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<SellingPlace> sellingPlaces = Arrays.asList(s1, s2, s3);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        sellingPlaceRepository.saveAll(sellingPlaces);
    }

    public void insertSettingData() {
        Setting s1 = new Setting(1, "Công ty TNHH Kỹ Thuật NIIT-ICT"
                , "0987654321"
                , ""
                , "Thiết bị mạng NIIT-ICT"
                , "niithanoi.edu.vn"
                , "hello@niithanoi.edu.vn"
                , "Tầng 3, 25T2, N05, Nguyễn Thị Thập, Cầu Giấy, Hà Nội"
                , "https://niithanoi.edu.vn/pic/banner/log_636686424391527334.png"
                , "https://niithanoi.edu.vn/pic/banner/log_636686424391527334.png"
                , "", "", "https://www.facebook.com/NIIT.ICT/"
                , "https://www.youtube.com/channel/UCqWcReCheBF-O6dlRf2CDRw"
                , ""
                , "https://twitter.com/day_ict"
                , ""
                , "https://niithanoi.edu.vn/img/boCongThuong.png",
                "Thiết bị mạng NIIT-ICT"
                , "Thiết bị mạng"
                , "Thiết bị mạng NIIT-ICT"
                , ""
                , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Setting> settings = Arrays.asList(s1);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        settingRepository.saveAll(settings);
    }

    public void insertSubCategoryData() {
        SubCategory s1 = new SubCategory(1, "Card mạng", "/images/category/s001.png", "Card mạng", "Card mạng", 1, 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SubCategory s3 = new SubCategory(3, "Bộ phát wifi 4G", "/images/category/s003.png", "Bộ phát wifi 4G", "Bộ phát wifi 4G", 3, 1, 3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SubCategory s4 = new SubCategory(4, "Wi-Fi công nghệ Mesh", "/images/category/s004.png", "Wi-Fi công nghệ Mesh", "Wi-Fi công nghệ Mesh", 4, 1, 4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        SubCategory s5 = new SubCategory(5, "Thiết bị mạng khuyến mãi", "/images/category/s005.png", "Thiết bị mạng khuyến mãi", "Thiết bị mạng khuyến mãi", 5, 1, 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<SubCategory> subCategories = Arrays.asList(s1, s3, s4, s5);
        // This exposes a saveAll method for us, which will batch several inserts into one.
        subCategoryRepository.saveAll(subCategories);
    }

    public void insertSubscriberData() {
        Subscriber s1 = new Subscriber(1, "admin@gmail.com", "random", "ACTIVE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Subscriber s2 = new Subscriber(2, "sale@gmail.com", "", "PENDING", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Subscriber s3 = new Subscriber(3, "shipper@gmail.com", "random", "STOPPING", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Subscriber> subscribers = Arrays.asList(s1, s2, s3);
        // This exposes a saveAll method for us, which will batch several inserts into one
        subscriberRepository.saveAll(subscribers);
    }

    public void insertUserData() {
        User u1 = new User(1, "Admin", "admin@gmail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "1234567890", "", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        User u2 = new User(2, "Sale", "sale@gmail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "1234567890", "", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        User u3 = new User(3, "Shipper", "shipper@gmail.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "1234567890", "", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<User> users = Arrays.asList(u1, u2, u3);
        // This exposes a saveAll method for us, which will batch several inserts into one
        userRepository.saveAll(users);
    }

    public void insertWarrantyData() {
        Warranty w1 = new Warranty(1, 1, 1, 1, "2 năm", "Bảo hành lỗi 1 đổi 1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Warranty w2 = new Warranty(2, 2, 2, 2, "1 năm", "Bảo hành lỗi 1 đổi 1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        Warranty w3 = new Warranty(3, 3, 3, 3, "1 năm", "Bảo hành lỗi 1 đổi 1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "admin", null, null);
        List<Warranty> warranties = Arrays.asList(w1, w2, w3);
        // This exposes a saveAll method for us, which will batch several inserts into one
        warrantyRepository.saveAll(warranties);
    }

    /**
     * Run insert master data
     */
    @GetMapping("/insert")
    public ResponseEntity<Object> insertMasterData() {
        this.truncateAllTables();
        this.insertAttributeData();
        this.insertBannerData();
        this.insertCategoryData();
        this.insertCustomerData();
        this.insertCommentData();
        this.insertInventoryData();
        this.insertManufactureData();
        this.insertOrderData();
        this.insertOrderItemData();
        this.insertPostData();
        this.insertProductData();
        this.insertProductDetailData();
        this.insertProductInventoryData();
        this.insertPromotionData();
        this.insertRoleData();
        this.insertShoppingCartData();
        this.insertSellingPlaceData();
        this.insertSettingData();
        this.insertSubCategoryData();
        this.insertSubscriberData();
        this.insertUserData();
        this.insertWarrantyData();
        return new ResponseEntity<>(
                "Đã thêm dữ liệu thuộc tính sản phẩm.<br/>" +
                "Đã thêm dữ liệu quảng cáo.<br/>" +
                        "Đã thêm dữ liệu danh mục cha.<br/>" +
                        "Đã thêm dữ liệu khách hàng.<br/>" +
                        "Đã thêm dữ liệu bình luận.<br/>" +
                        "Đã thêm dữ liệu kho.<br/>" +
                        "Đã thêm dữ liệu hãng sản xuất.<br/>" +
                        "Đã thêm dữ liệu đơn hàng.<br/>" +
                        "Đã thêm dữ liệu sản phẩm trong đơn hàng.<br/>" +
                        "Đã thêm dữ liệu bài viết.<br/>" +
                        "Đã thêm dữ liệu sản phẩm.<br/>" +
                        "Đã thêm dữ liệu chi tiết sản phẩm.<br/>" +
                        "Đã thêm dữ liệu kho sản phẩm.<br/>" +
                        "Đã thêm dữ liệu khuyến mãi.<br/>" +
                        "Đã thêm dữ liệu phân quyền.<br/>" +
                        "Đã thêm dữ liệu giỏ hàng.<br/>" +
                        "Đã thêm dữ liệu nơi bán.<br/>" +
                        "Đã thêm dữ liệu cài đặt.<br/>" +
                        "Đã thêm dữ liệu danh mục con.<br/>" +
                        "Đã thêm dữ liệu đăng ký nhận tin.<br/>" +
                        "Đã thêm dữ liệu người quản trị.<br/>" +
                        "Đã thêm dữ liệu bảo hành."
                , HttpStatus.OK);
    }

    /**
     * Run import master data
     */
    @PostMapping("/import")
    public ResponseEntity<Object> importMasterData(@RequestParam("file") MultipartFile file) throws IOException {
        String sql0 = "SET foreign_key_checks = 0";
        String sql1 = "TRUNCATE TABLE categories";
        String sql2 = "SET foreign_key_checks = 1";
        jdbcTemplate.execute(sql0);
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
        List<Category> categoryList = Csv.csvToCategoryList(file.getInputStream());
        categoryRepository.saveAll(categoryList);
        return ResponseHandler.generateResponse(HttpStatus.OK, "Đã import dữ liệu thành công.", null);
    }
}
