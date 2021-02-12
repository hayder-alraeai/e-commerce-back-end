package com.onlineshop.alraeaei.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlineshop.alraeaei.models.Product;
import lombok.Value;

@Value
public class OrderProductDTO {
    @JsonProperty
    String productId;
    @JsonProperty
    int quantity;
}
