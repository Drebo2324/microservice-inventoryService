package com.drebo.microservices.inventory.controller;

import com.drebo.microservices.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@RequestParam String sku, @RequestParam Integer quantity){
        log.info("Checking inventory -> sku:{} quantity:{}", sku, quantity);
        return inventoryService.inStock(sku, quantity);
    }

}
