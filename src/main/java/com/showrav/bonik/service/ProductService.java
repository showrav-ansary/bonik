package com.showrav.bonik.service;

import com.showrav.bonik.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProductSortedByName();
}
