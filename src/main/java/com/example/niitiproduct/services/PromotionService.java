package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.mapper.PromotionMapper;
import com.example.niitiproduct.models.Promotion;
import com.example.niitiproduct.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionMapper promotionMapper;
    @Autowired
    private PromotionRepository promotionRepository;

    /**
     * Get all promotions
     * @return
     */
    public List<PromotionDTO> getAll() {
        return promotionRepository.findAll().stream().map(e->promotionMapper.toDTO(e)).toList();
    }

    /**
     * Search by promotion name
     * @param name
     * @return
     */
    public List<Promotion> searchByName(String name) {
        return promotionRepository.findByNameContaining(name);
    }

    /**
     * Edit promotion
     * @param id
     * @return
     */
    public Promotion findById(Long id) {
        return promotionRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update promotion
     * @param promotion
     * @return
     */
    public boolean save(Promotion promotion) {
        try {
            Promotion promotionData = new Promotion();
            promotionData.setId(promotion.getId());
            promotionData.setName(promotion.getName());
            promotionData.setDescription(promotion.getDescription());
            promotionData.setDiscount_type(promotion.getDiscount_type());
            promotionData.setDiscount_price(promotion.getDiscount_price());
            promotionData.setDiscount_rate(promotion.getDiscount_rate());
            promotionData.setStart_time(promotion.getStart_time());
            promotionData.setEnd_time(promotion.getEnd_time());
            promotionData.setIs_actived(promotion.getIs_actived() != null ? promotion.getIs_actived() : 0);
            promotionData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            promotionData.setCreated_by(String.valueOf(1));
            promotionData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            promotionData.setUpdated_by(String.valueOf(1));
            promotionRepository.save(promotionData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete promotion
     * @param id
     */
    public void delete(Long id) {
        try {
            promotionRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
