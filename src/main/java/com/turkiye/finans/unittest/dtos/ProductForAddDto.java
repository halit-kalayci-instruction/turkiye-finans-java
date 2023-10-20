package com.turkiye.finans.unittest.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForAddDto {
    @NotBlank()
    private String name;
    @Min(1)
    private double unitPrice;
    @Min(1)
    private int unitsInStock;
}
