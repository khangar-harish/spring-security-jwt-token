package com.hash.springbootsecurity.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private int productId;
    private String name;
    private int qty;
    private double price;
}
