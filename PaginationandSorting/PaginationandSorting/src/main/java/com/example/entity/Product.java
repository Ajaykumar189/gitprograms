package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT_TBL")
public class Product {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quality;
    private Long price;

    public Product(String name, int quality, Long price) {
        this.name = name;
        this.quality = quality;
        this.price = price;
    }
}
