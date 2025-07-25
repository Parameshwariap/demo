package com.buyapp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
 
public class OrderResponseDto {
 
    private Long orderId;
    private Long userId;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime orderDate;
 
    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
 
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
 
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
 
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
 
