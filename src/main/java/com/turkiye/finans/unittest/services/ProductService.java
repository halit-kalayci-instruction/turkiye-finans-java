package com.turkiye.finans.unittest.services;

import com.turkiye.finans.unittest.dtos.ProductDetailDto;
import com.turkiye.finans.unittest.dtos.ProductForAddDto;

public interface ProductService {
    ProductDetailDto add(ProductForAddDto productForAddDto);
}
