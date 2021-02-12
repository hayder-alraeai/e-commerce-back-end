package com.onlineshop.alraeaei.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlineshop.alraeaei.models.Product;
import lombok.Value;

import java.util.List;

@Value
public class OrderDTO {
    @JsonProperty
    List<OrderProductDTO> products;
    @JsonProperty
    String firstName;
    @JsonProperty
    String lastName;
    @JsonProperty
    String email;
    @JsonProperty
    String address;
    @JsonProperty
    int zipCode;
    @JsonProperty
    String state;
}
