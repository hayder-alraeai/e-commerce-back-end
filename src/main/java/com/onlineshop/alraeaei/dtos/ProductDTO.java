package com.onlineshop.alraeaei.dtos;

import com.onlineshop.alraeaei.models.Category;
import lombok.Value;

@Value
public class ProductDTO {
    private Category category;
    private String productDescription;
    private byte [] image;
    private double productPrice;
}
