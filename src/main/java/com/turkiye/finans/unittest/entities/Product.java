package com.turkiye.finans.unittest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="products")
@Entity
public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;
}
