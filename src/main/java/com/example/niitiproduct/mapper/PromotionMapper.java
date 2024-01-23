package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.models.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {
    public PromotionDTO toDTO(Promotion promotion) {
        return PromotionDTO.builder(
                ).id(promotion.getId())
                .name(promotion.getP00_name())
                .description(promotion.getP01_description())
                .discount_type(promotion.getP02_discount_type())
                .discount_price(promotion.getP03_discount_price())
                .discount_rate(promotion.getP04_discount_rate())
                .start_time(promotion.getP05_start_time())
                .end_time(promotion.getP06_end_time())
                .is_actived(promotion.getP07_is_actived())
                .created_at(promotion.getP08_created_at())
                .created_by(promotion.getP09_created_by())
                .updated_at(promotion.getP10_updated_at())
                .updated_by(promotion.getP11_updated_by())
                .deleted_at(promotion.getP12_deleted_at())
                .deleted_by(promotion.getP13_deleted_by())
                .build();
    }
}
