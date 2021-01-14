package com.onlineshop.alraeaei.dtos;

import com.onlineshop.alraeaei.models.Category;
import lombok.Value;

@Value
public class ProductDTO {
    private String categoryId;
    private String productDescription;
    private String image;
    private double productPrice;
}
