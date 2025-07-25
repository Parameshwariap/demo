package com.buyapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.buyapp.dto.OrderItemDto;
import com.buyapp.dto.OrderRequestDto;
import com.buyapp.dto.OrderResponseDto;
import com.buyapp.entity.Order;
import com.buyapp.entity.OrderItem;
import com.buyapp.repository.OrderRepository;
import com.buyapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
 
    private final OrderRepository orderRepository;
 
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
 
    @Override
    public OrderResponseDto placeOrder(OrderRequestDto requestDto) {
 
        // Simulate user validation
        Long userId = requestDto.getUserId();
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }
 
        // Simulate fetching product prices from external service
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
 
        for (OrderItemDto itemDto : requestDto.getItems()) {
            Long productId = itemDto.getProductId();
            Integer quantity = itemDto.getQuantity();
 
            BigDecimal price = BigDecimal.valueOf(100); // Simulated price
            BigDecimal itemTotal = price.multiply(BigDecimal.valueOf(quantity));
            totalAmount = totalAmount.add(itemTotal);
 
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(productId);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(price);
            orderItems.add(orderItem);
        }
 
        // Save order
        Order order = new Order();
        order.setUserId(userId);
        order.setAccountNumber(requestDto.getAccountNumber());
        order.setStatus("PLACED");
        order.setTotalAmount(totalAmount);
        order.setCreatedAt(LocalDateTime.now());
 
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }
 
        order.setItems(orderItems);
 
        Order savedOrder = orderRepository.save(order);
 
        // Return response
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setOrderId(savedOrder.getId());
        responseDto.setUserId(savedOrder.getUserId());
        responseDto.setTotalAmount(savedOrder.getTotalAmount());
        responseDto.setStatus(savedOrder.getStatus());
        responseDto.setOrderDate(savedOrder.getCreatedAt());
 
        return responseDto;
    }
}
 
