package com.example.niitiproduct.mapper;

import com.example.niitiproduct.dto.InventoryDTO;
import com.example.niitiproduct.models.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryDTO toDTO(Inventory inventory) {
        return InventoryDTO.builder(
                ).id(inventory.getId())
                .name(inventory.getName())
                .address(inventory.getAddress())
                .created_at(inventory.getCreated_at())
                .created_by(inventory.getCreated_by())
                .updated_at(inventory.getUpdated_at())
                .updated_by(inventory.getUpdated_by())
                .deleted_at(inventory.getDeleted_at())
                .deleted_by(inventory.getDeleted_by())
                .build();
    }
}
