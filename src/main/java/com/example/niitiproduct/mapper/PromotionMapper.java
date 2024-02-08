package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.PromotionDTO;
import com.example.niitiproduct.models.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {
    public PromotionDTO toDTO(Promotion promotion) {
        return PromotionDTO.builder(
                ).id(promotion.getId())
                .name(promotion.getName())
                .description(promotion.getDescription())
                .discount_type(promotion.getDiscount_type())
                .discount_price(promotion.getDiscount_price())
                .discount_rate(promotion.getDiscount_rate())
                .start_time(promotion.getStart_time())
                .end_time(promotion.getEnd_time())
                .is_actived(promotion.getIs_actived())
                .created_at(promotion.getCreated_at())
                .created_by(promotion.getCreated_by())
                .updated_at(promotion.getUpdated_at())
                .updated_by(promotion.getUpdated_by())
                .deleted_at(promotion.getDeleted_at())
                .deleted_by(promotion.getDeleted_by())
                .build();
    }
}
