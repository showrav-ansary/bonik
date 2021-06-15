package com.showrav.bonik.repository;

import com.showrav.bonik.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAllProducts();

	Optional<Product> findById(Long productId);
}
