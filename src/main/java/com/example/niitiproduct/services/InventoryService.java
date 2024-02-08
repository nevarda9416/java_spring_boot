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

    /**
     * Get all products
     * @return
     */
    public List<InventoryDTO> getAll() {
        return inventoryRepository.findAllByOrderByIdDesc().stream().map(e->inventoryMapper.toDTO(e)).toList();
    }

    /**
     * Search by product name
     * @param name
     * @return
     */
    public List<Inventory> searchByName(String name) {
        return inventoryRepository.findByNameContaining(name);
    }

    /**
     * Edit product
     * @param id
     * @return
     */
    public Inventory findById(Long id) {
        return inventoryRepository.findById(Math.toIntExact(id)).get();
    }

    /**
     * Insert/Update inventory
     * @param inventory
     * @return
     */
    public boolean save(Inventory inventory) {
        try {
            Inventory inventoryData = new Inventory();
            inventoryData.setName(inventory.getName());
            inventoryData.setAddress(inventory.getAddress());
            inventoryData.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inventoryData.setCreated_by(String.valueOf(1));
            inventoryData.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            inventoryData.setUpdated_by(String.valueOf(1));
            inventoryRepository.save(inventoryData);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Delete product
     * @param id
     */
    public void delete(Long id) {
        try {
            inventoryRepository.deleteById(Math.toIntExact(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




