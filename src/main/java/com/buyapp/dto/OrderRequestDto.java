package com.buyapp.dto;

import jakarta.validation.constraints.*;
import java.util.List;
 
public class OrderRequestDto {
 
    @NotNull(message = "User ID cannot be null")
    private Long userId;
 
    @NotBlank(message = "Account number is required")
    private String accountNumber;
 
    @NotEmpty(message = "Product list cannot be empty")
    private List<OrderItemDto> items;
 
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
 
    public List<OrderItemDto> getItems() {
        return items;
    }
    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}