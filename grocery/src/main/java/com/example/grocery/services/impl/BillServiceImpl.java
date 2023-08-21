package com.example.grocery.services.impl;

import com.example.grocery.dtos.BillRequestDto;
import com.example.grocery.dtos.StandardResponseDto;
import com.example.grocery.models.Inventory;
import com.example.grocery.repositories.InventoryRepository;
import com.example.grocery.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public StandardResponseDto getBill(List<BillRequestDto> itemList) {
        double totalAmount=0;
        for(BillRequestDto item: itemList){
            Inventory inv= inventoryRepository.findById(item.getGrocery_id()).get();
            totalAmount+=(inv.getUnit_price()* item.getQuantity());
        }
        return new StandardResponseDto("Total Amount:", totalAmount);
    }
}
