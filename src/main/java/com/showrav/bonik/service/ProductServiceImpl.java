package com.showrav.bonik.service;

import com.showrav.bonik.domain.Product;
import com.showrav.bonik.dto.ProductDTO;
import com.showrav.bonik.repository.ProductRepository;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Inject
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDTO> findAllProductSortedByName() {

		return productRepository.findAllProducts()
						.stream()
						.map(this::convertToDTO)
						.sorted(Comparator.comparing(ProductDTO::getName))
						.collect(Collectors.toList());
	}

	private ProductDTO convertToDTO(Product product) {

		return new ProductDTO(
						product.getId(),
						product.getName(),
						product.getDescription(),
						product.getPrice()
		);
	}
}
