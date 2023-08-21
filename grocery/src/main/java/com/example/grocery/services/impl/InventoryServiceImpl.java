package com.example.grocery.services.impl;

import com.example.grocery.dtos.InventoryRequestDto;
import com.example.grocery.dtos.StandardResponseDto;
import com.example.grocery.models.Inventory;
import com.example.grocery.repositories.InventoryRepository;
import com.example.grocery.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public StandardResponseDto getAllInv(){
        try {
            List<Inventory> invList=inventoryRepository.findAll();
            return new StandardResponseDto("Success",invList);
        }
        catch (Exception e){
            return new StandardResponseDto(e.getMessage(),null);
        }
    }

    @Override
    public StandardResponseDto getInventoryById(Integer id){
        try {
            Inventory inv= inventoryRepository.findById(id).get();
            return new StandardResponseDto("Success",inv) ;
        }
        catch(Exception e){
            return new StandardResponseDto(e.getMessage(),null);

        }
    }

    @Override
    public StandardResponseDto addInventory(InventoryRequestDto inventory) {
        try {
            Inventory inv= new Inventory();
            inv.setGrocery_name(inventory.getGrocery_name());
            inv.setUnit_price(inventory.getUnit_price());
            inventoryRepository.save(inv);
            return new StandardResponseDto("Success",inv);
        }
        catch(Exception e){
            return new StandardResponseDto(e.getMessage(),null);
        }
    }

    @Override
    public StandardResponseDto deleteInventorybyId(Integer id) {
        try{
            Inventory inv= inventoryRepository.findById(id).get();
            inventoryRepository.delete(inv);
            return new StandardResponseDto("Successfully Deleted",null);
        }
        catch (Exception e){
            return new StandardResponseDto(e.getMessage(),null);
        }
    }

    @Override
    public StandardResponseDto updateInventory(Inventory inventory) {
        try {
            Inventory inv= inventoryRepository.findById(inventory.getId()).get();
            inv.setGrocery_name(inventory.getGrocery_name());
            inv.setUnit_price(inventory.getUnit_price());
            return new StandardResponseDto("Successfully Updated",inv);
        }
        catch(Exception e){
            return new StandardResponseDto(e.getMessage(),null);

        }
    }
}
