package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.mapper.SubCategoryMapper;
import com.example.niitiproduct.models.Product;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    SubCategoryMapper subCategoryMapper;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    /**
     * Get all sub categories
     * @return
     */
    public List<SubCategoryDTO> getAll() {
        return subCategoryRepository.findAllByOrderByIdDesc().stream().map(e->subCategoryMapper.toDTO(e)).toList();
    }

    /**
     * Search by sub category name
     * @param name
     * @return
     */
    public List<SubCategory> searchByName(String name) {
        return subCategoryRepository.findByNameContaining(name);
    }

    /**
     * Edit sub category
     * @param id
     * @return
     */
    public SubCategory findById(Long id) {
        return subCategoryRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update sub category
     * @param sub category
     * @return
     */
    public boolean save(SubCategory subCategory) {
        try {
            SubCategory subCategoryData = new SubCategory();
            subCategoryData.setName(subCategory.getName());
            subCategoryData.setImage(subCategory.getImage());
            subCategoryData.setSummary(subCategory.getSummary());
            subCategoryData.setDescription(subCategory.getDescription());
            subCategoryData.setDisplay_order(subCategory.getDisplay_order());
            subCategoryData.setIs_actived(subCategory.getIs_actived() != null ? subCategory.getIs_actived() : 0);
            subCategoryData.setCategory_id(subCategory.getCategory_id());
            subCategoryData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subCategoryData.setCreated_by(String.valueOf(1));
            subCategoryData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subCategoryData.setUpdated_by(String.valueOf(1));
            subCategoryRepository.save(subCategoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete sub category
     * @param id
     */
    public void delete(Long id) {
        try {
            subCategoryRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllSubCategories() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        return new ResponseEntity<>(subCategoryList, HttpStatus.OK);
    }
}
