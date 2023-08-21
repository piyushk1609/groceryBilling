package com.example.grocery.controller;

import com.example.grocery.dtos.InventoryRequestDto;
import com.example.grocery.dtos.StandardResponseDto;
import com.example.grocery.services.InventoryService;
import com.example.grocery.models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class inventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public StandardResponseDto getAllInventory(){
        return inventoryService.getAllInv();
    }

    @GetMapping("/inventory/{id}")
    public StandardResponseDto getInventoryById(@PathVariable Integer id){
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/inventory")
    public StandardResponseDto addInventory(@RequestBody InventoryRequestDto inventory){
        return inventoryService.addInventory(inventory);
    }

    @DeleteMapping("/inventory/{id}")
    public StandardResponseDto deleteInventory(@PathVariable Integer id){
        return inventoryService.deleteInventorybyId(id);
    }

    @PutMapping("/inventory")
    public StandardResponseDto updateInventory(@RequestBody Inventory inventory){
        return inventoryService.updateInventory(inventory);
    }
}
