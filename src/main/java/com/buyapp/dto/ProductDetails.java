package com.buyapp.dto;

import java.math.BigDecimal;

public class ProductDetails {
 
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer availableQuantity;
 
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
this.id = id;
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
this.name = name;
    }
 
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
 
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
