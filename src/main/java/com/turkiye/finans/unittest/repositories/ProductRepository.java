package com.turkiye.finans.unittest.repositories;

import com.turkiye.finans.unittest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository
        extends JpaRepository<Product,Integer> {
    // Derived Query Methods
    Optional<Product> findByName(String name);
}
