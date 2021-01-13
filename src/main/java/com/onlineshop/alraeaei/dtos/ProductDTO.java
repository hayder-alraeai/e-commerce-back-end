package com.onlineshop.alraeaei.dtos;

import lombok.Value;

@Value
public class ProductDTO {
    private String category;
    private String productDescription;
    private String image;
    private double productPrice;
}
