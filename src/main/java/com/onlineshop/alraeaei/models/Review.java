package com.onlineshop.alraeaei.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    String id;
    String productId;
    String name;
    String comment;
    Date timeStamp = new Date(System.currentTimeMillis());
    int rate;

    public Review(String productId, String name, String comment, int rate) {
        this.productId = productId;
        this.name = name;
        this.comment = comment;
        this.rate = rate;
    }
}
