package com.example.niitiproduct.services;

import com.example.niitiproduct.dto.InventoryDTO;
import com.example.niitiproduct.mapper.InventoryMapper;
import com.example.niitiproduct.models.Inventory;
import com.example.niitiproduct.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    private InventoryRepository inventoryRepository;
    public List<InventoryDTO> getAll() {
        return inventoryRepository.findAllByOrderByIdDesc().stream().map(e->inventoryMapper.toDTO(e)).toList();
    }
    public boolean save(Inventory inventory) {
        try {
            Inventory inventoryData = new Inventory();
            inventoryData.setI00_name(inventory.getI00_name());
            inventoryData.setI01_address(inventory.getI01_address());
            inventoryData.setI02_created_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inventoryData.setI03_created_by(String.valueOf(1));
            inventoryData.setI04_updated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inventoryData.setI05_updated_by(String.valueOf(1));
            inventoryRepository.save(inventoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}




