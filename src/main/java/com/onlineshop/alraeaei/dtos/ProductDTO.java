package com.onlineshop.alraeaei.dtos;

import com.onlineshop.alraeaei.models.Category;
import lombok.Value;

import java.util.Date;

@Value
public class ProductDTO {
    private Category category;
    private String productDescription;
    private byte [] image;
    private double productPrice;
    private int quantity;
    private int stock;
}
