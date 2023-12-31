package com.turkiye.finans.unittest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDto {
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;
}
