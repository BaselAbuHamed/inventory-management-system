package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto productDto);

    ProductDto patchProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
