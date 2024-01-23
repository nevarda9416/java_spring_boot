package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.WarrantyDTO;
import com.example.niitiproduct.models.Warranty;
import org.springframework.stereotype.Component;

@Component
public class WarrantyMapper {
    public WarrantyDTO toDTO(Warranty warranty) {
        return WarrantyDTO.builder(
                ).id(warranty.getId())
                .customer_id(warranty.getW00_customer_id())
                .order_id(warranty.getW01_order_id())
                .product_id(warranty.getW02_product_id())
                .period(warranty.getW03_period())
                .description(warranty.getW04_description())
                .created_at(warranty.getW05_created_at())
                .created_by(warranty.getW06_created_by())
                .updated_at(warranty.getW07_updated_at())
                .updated_by(warranty.getW08_updated_by())
                .deleted_at(warranty.getW09_deleted_at())
                .deleted_by(warranty.getW10_deleted_by())
                .build();
    }
}
