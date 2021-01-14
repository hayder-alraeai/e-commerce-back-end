package com.onlineshop.alraeaei.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlineshop.alraeaei.models.Product;
import lombok.Value;

import java.util.List;

@Value
public class CategoryDTO {

    private String categoryName;
    private List<Product> products;
}
