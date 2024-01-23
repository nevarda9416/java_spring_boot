package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.SubCategoryDTO;
import com.example.niitiproduct.mapper.SubCategoryMapper;
import com.example.niitiproduct.models.SubCategory;
import com.example.niitiproduct.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public List<SubCategoryDTO> getAll() {
        return subCategoryRepository.findAllByOrderByIdDesc().stream().map(e->subCategoryMapper.toDTO(e)).toList();
    }
    public boolean save(SubCategory subCategory) {
        try {
            SubCategory subCategoryData = new SubCategory();
            subCategoryData.setS00_name(subCategory.getS00_name());
            subCategoryData.setS01_image(subCategory.getS01_image());
            subCategoryData.setS02_summary(subCategory.getS02_summary());
            subCategoryData.setS03_description(subCategory.getS03_description());
            subCategoryData.setS04_display_order(subCategory.getS04_display_order());
            subCategoryData.setS05_is_actived(subCategory.getS05_is_actived() != null ? subCategory.getS05_is_actived() : 0);
            subCategoryData.setS06_category_id(subCategory.getS06_category_id());
            subCategoryData.setS07_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subCategoryData.setS08_created_by(String.valueOf(1));
            subCategoryData.setS09_updated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            subCategoryData.setS10_updated_by(String.valueOf(1));
            subCategoryRepository.save(subCategoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
