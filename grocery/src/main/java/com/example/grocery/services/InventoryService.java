package com.example.grocery.services;

import com.example.grocery.dtos.InventoryRequestDto;
import com.example.grocery.dtos.StandardResponseDto;
import com.example.grocery.models.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InventoryService {
    StandardResponseDto getAllInv();

    StandardResponseDto getInventoryById(Integer id);

    StandardResponseDto addInventory(InventoryRequestDto inventory);

    StandardResponseDto deleteInventorybyId(Integer id);

    StandardResponseDto updateInventory(Inventory inventory);
}
