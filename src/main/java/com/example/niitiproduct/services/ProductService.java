package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.ProductDTO;
import com.example.niitiproduct.mapper.ProductMapper;
import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.models.ProductPromotion;
import com.example.niitiproduct.repositories.ProductPromotionRepository;
import com.example.niitiproduct.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPromotionRepository productPromotionRepository;

    /**
     * Get all products
     * @return
     */
    public List<ProductDTO> getAll() {
        return productRepository.findAllByOrderByIdDesc().stream().map(e->productMapper.toDTO(e)).toList();
    }

    /**
     * Search by product name
     * @param name
     * @return
     */
    public List<Product> searchByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    /**
     * Edit product
     *
     * @param id
     * @return
     */
    public List<ProductPromotion> findById(Long id) {
        return productPromotionRepository.findFirstByProduct_IdOrderByIdDesc(Math.toIntExact(id));
    }

    /**
     * Insert/Update product
     * @param product
     * @return
     */
    public boolean save(Product product) {
        try {
            Product productData = new Product();
            productData.setId(product.getId());
            productData.setName(product.getName());
            productData.setShort_description(product.getShort_description());
            productData.setLong_description(product.getLong_description());
            productData.setCategory_id(product.getCategory_id());
            productData.setDisplay_order(product.getDisplay_order());
            productData.setMeta_title(product.getMeta_title());
            productData.setMeta_keyword(product.getMeta_keyword());
            productData.setMeta_description(product.getMeta_description());
            productData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            productData.setCreated_by(String.valueOf(1));
            productData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            productData.setUpdated_by(String.valueOf(1));
            productRepository.save(productData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete product
     * @param id
     */
    public void delete(Long id) {
        try {
            productRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
