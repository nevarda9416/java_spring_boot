package com.example.niitiproduct.repositories;

import com.example.niitiproduct.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderByIdDesc();

    List<Product> findByNameContaining(String name);

    @Query("SELECT p FROM Product p WHERE p.category_id = ?1")
    List<Product> findProductsByCategory_id(Integer categoryId);

    @Query("SELECT p FROM Product p INNER JOIN Category c ON c.id = p.category_id WHERE c.slug = ?1")
    List<Product> findProductsByCategory_slug(String categorySlug);

    @Query("SELECT p FROM Product p WHERE p.id IN ?1")
    List<Product> getListProductDetails(List<Integer> listProductIds);

    @Query(value = "SELECT list_attribute_ids FROM product_details d INNER JOIN products p ON p.id = d.product_id WHERE p.slug = ?1", nativeQuery = true)
    String findByProductSlug(String slug);

    @Query(value = "SELECT p.*,d.*,(SELECT GROUP_CONCAT(a.value) FROM attributes a WHERE FIND_IN_SET (a.id, (SELECT GROUP_CONCAT(list_attribute_ids)))) AS listattribute_values FROM products p INNER JOIN product_details d ON d.product_id = p.id WHERE p.slug = ?1", nativeQuery = true)
    List<Map<String, Object>> findBySlug(String slug);
}
