package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.InventoryDTO;
import com.example.niitiproduct.models.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryDTO toDTO(Inventory inventory) {
        return InventoryDTO.builder(
                ).id(inventory.getId())
                .name(inventory.getI00_name())
                .address(inventory.getI01_address())
                .created_at(inventory.getI02_created_at())
                .created_by(inventory.getI03_created_by())
                .updated_at(inventory.getI04_updated_at())
                .updated_by(inventory.getI05_updated_by())
                .deleted_at(inventory.getI06_deleted_at())
                .deleted_by(inventory.getI07_deleted_by())
                .build();
    }
}
