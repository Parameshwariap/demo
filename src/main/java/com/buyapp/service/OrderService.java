package com.buyapp.service;

import com.buyapp.dto.OrderRequestDto;
import com.buyapp.dto.OrderResponseDto;

public interface OrderService {
 
    OrderResponseDto placeOrder(OrderRequestDto requestDto);
}
