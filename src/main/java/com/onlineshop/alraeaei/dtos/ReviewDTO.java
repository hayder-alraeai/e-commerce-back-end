package com.onlineshop.alraeaei.dtos;

import lombok.Value;

import java.util.Date;
@Value
public class ReviewDTO {
    String productId;
    String name;
    String comment;
    Date timeStamp;
    int rate;
}
