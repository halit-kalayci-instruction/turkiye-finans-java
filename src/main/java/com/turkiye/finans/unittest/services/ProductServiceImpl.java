package com.turkiye.finans.unittest.services;

import com.turkiye.finans.unittest.dtos.ProductDetailDto;
import com.turkiye.finans.unittest.dtos.ProductForAddDto;
import com.turkiye.finans.unittest.entities.Product;
import com.turkiye.finans.unittest.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;


    @Override
    public ProductDetailDto add(ProductForAddDto productForAddDto)
    {
        // 1=> veritabanında eklenmek istenen isimde bir veri olması
        // 2=> veritabanında eklenmek istenen isimde bir veri olmaması
        Product productWithSameName = productRepository
                .findByName(productForAddDto.getName())
                .orElse(null);

        if(productWithSameName != null)
            throw new RuntimeException("Product with same name exists");

        Product productToAdd = Product
                .builder()
                .name(productForAddDto.getName())
                .unitPrice(productForAddDto.getUnitPrice())
                .unitsInStock(productForAddDto.getUnitsInStock())
                .build();
        productToAdd = productRepository.save(productToAdd);

        ProductDetailDto response = ProductDetailDto.builder()
                .id(productToAdd.getId())
                .name(productToAdd.getName())
                .unitPrice(productToAdd.getUnitPrice())
                .unitsInStock(productToAdd.getUnitsInStock())
                .build();
        return response;
    }
}
