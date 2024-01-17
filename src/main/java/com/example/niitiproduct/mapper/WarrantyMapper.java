package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.models.Warranty;
import org.springframework.stereotype.Component;

@Component
public class WarrantyMapper {
    public WarrantyDTO toDTO(Warranty warranty) {
        return WarrantyDTO.builder(
                ).id(warranty.getId())
                .customer_id(warranty.getCustomer_id())
                .order_id(warranty.getOrder_id())
                .product_id(warranty.getProduct_id())
                .period(warranty.getPeriod())
                .description(warranty.getDescription())
                .created_at(warranty.getCreated_at())
                .created_by(warranty.getCreated_by())
                .updated_at(warranty.getUpdated_at())
                .updated_by(warranty.getUpdated_by())
                .deleted_at(warranty.getDeleted_at())
                .deleted_by(warranty.getDeleted_by())
                .build();
    }
}
