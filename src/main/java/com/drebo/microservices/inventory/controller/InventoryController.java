package com.drebo.microservices.inventory.controller;

import com.drebo.microservices.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return inventoryService.inStock(sku, quantity);
    }

}
