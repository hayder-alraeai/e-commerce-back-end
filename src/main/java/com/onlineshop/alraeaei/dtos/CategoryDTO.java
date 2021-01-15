package com.onlineshop.alraeaei.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;


@Value
public class CategoryDTO {
    @JsonProperty
    private String categoryId;
    @JsonProperty
    private String categoryName;
}
