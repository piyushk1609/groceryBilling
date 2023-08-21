package com.example.grocery.services;

import com.example.grocery.dtos.BillRequestDto;
import com.example.grocery.dtos.StandardResponseDto;

import java.util.List;

public interface BillService {
    StandardResponseDto getBill(List<BillRequestDto> itemList);
}
