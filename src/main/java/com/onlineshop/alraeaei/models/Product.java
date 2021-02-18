package com.onlineshop.alraeaei.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne
    private Category category;
    private String productDescription;
    private String imageId;
    private double productPrice;
    private int quantity;
    private int stock;
    private int rates;
    private Date creationTime = new Date(System.currentTimeMillis());

}
