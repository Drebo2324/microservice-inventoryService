package com.drebo.microservices.inventory.repository;

import com.drebo.microservices.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuAndQuantityIsGreaterThanEqual(String sku, Integer quantity);
}
