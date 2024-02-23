package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.ProductInventoryDTO;
import com.example.niitiproduct.models.ProductInventory;
import org.springframework.stereotype.Component;

@Component
public class ProductInventoryMapper {
    public ProductInventoryDTO toDTO(ProductInventory productInventory) {
        return ProductInventoryDTO.builder(
                ).id(productInventory.getId())
                .product_detail_id(productInventory.getProduct_detail_id())
                .inventory_id(productInventory.getInventory_id())
                .quantity_inventory(productInventory.getQuantity_inventory())
                .selling_place_id(productInventory.getSelling_place_id())
                .quantity_selling_place(productInventory.getQuantity_selling_place())
                .created_at(productInventory.getCreated_at())
                .created_by(productInventory.getCreated_by())
                .updated_at(productInventory.getUpdated_at())
                .updated_by(productInventory.getUpdated_by())
                .deleted_at(productInventory.getDeleted_at())
                .deleted_by(productInventory.getDeleted_by())
                .build();
    }
}
