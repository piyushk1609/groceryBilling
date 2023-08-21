package com.example.grocery.controller;

import com.example.grocery.dtos.BillRequestDto;
import com.example.grocery.dtos.StandardResponseDto;
import com.example.grocery.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/bill")
    public StandardResponseDto getBill(@RequestBody List<BillRequestDto> itemList){
        return billService.getBill(itemList);
    }


}
