package com.onlineshop.alraeaei.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_row")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    String id;
    @OneToMany(fetch = FetchType.EAGER)
    List<OrderProduct> orderProducts;
    String firstName;
    String lastName;
    String email;
    String address;
    int zipCode;
    String state;

    public Order(List<OrderProduct> orderProducts, String firstName, String lastName, String email, String address, int zipCode, String state) {
        this.orderProducts = orderProducts;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.state = state;
    }
}
