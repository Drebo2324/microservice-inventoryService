package com.drebo.microservices.inventory.service;

import com.drebo.microservices.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public boolean inStock(String sku, Integer quantity){
        return inventoryRepository.existsBySkuAndQuantityIsGreaterThanEqual(sku, quantity);
    }
}
