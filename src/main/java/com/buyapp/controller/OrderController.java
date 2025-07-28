package com.buyapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyapp.dto.OrderRequestDto;
import com.buyapp.dto.OrderResponseDto;
import com.buyapp.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
 
    private final OrderService orderService;
 
    // Constructor injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
 
    @PostMapping("/buy")
    public ResponseEntity<OrderResponseDto> placeOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto response = orderService.placeOrder(orderRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
 
}