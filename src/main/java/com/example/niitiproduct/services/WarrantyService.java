package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.mapper.WarrantyMapper;
import com.example.niitiproduct.models.Warranty;
import com.example.niitiproduct.repositories.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WarrantyService {
    @Autowired
    WarrantyMapper warrantyMapper;
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    /**
     * Get all warranties
     * @return
     */
    public List<WarrantyDTO> getAll() {
        return warrantyRepository.findAll().stream().map(e->warrantyMapper.toDTO(e)).toList();
    }

    /**
     * Edit product
     * @param id
     * @return
     */
    public Warranty findById(Long id) {
        return warrantyRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update product
     * @param product
     * @return
     */
    public boolean save(Warranty product) {
        try {
            Warranty productData = new Warranty();
            productData.setId(product.getId());
            productData.setCustomer_id(product.getCustomer_id());
            productData.setOrder_id(product.getOrder_id());
            productData.setProduct_id(product.getProduct_id());
            productData.setPeriod(product.getPeriod());
            productData.setDescription(product.getDescription());
            productData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            productData.setCreated_by(String.valueOf(1));
            productData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            productData.setUpdated_by(String.valueOf(1));
            warrantyRepository.save(productData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete warranty
     * @param id
     */
    public void delete(Long id) {
        try {
            warrantyRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
