package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.ProductDto;
import edu.comp4382.inventorymanagementsystem.entity.Product;
import edu.comp4382.inventorymanagementsystem.mapper.ProductMapper;
import edu.comp4382.inventorymanagementsystem.repository.ProductRepository;
import edu.comp4382.inventorymanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductMapper productMapper;
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException
                                ("Product not found with given id : " + id));
        return productMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : products) {
            productDto.add(productMapper.mapToProductDto(product));
        }
        return productDto;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException
                                ("Product not found with given id : " + id));

        product.setProductName(productDto.getProductName());
        product.setProductNumber(productDto.getProductNumber());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());

        Product updatedProduct = productRepository.save(product);

        return productMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public ProductDto patchProduct(Long id, ProductDto productDto) {

        Product product = productRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException
                                ("Product not found with given id : " + id));

        if (productDto.getProductName() != null) {
            product.setProductName(productDto.getProductName());
        }
        if (productDto.getProductNumber() != null) {
            product.setProductNumber(productDto.getProductNumber());
        }
        if (!Double.isNaN(productDto.getProductPrice())) {
            product.setProductPrice(productDto.getProductPrice());
        }
        if (productDto.getProductQuantity() != 0) {
            product.setProductQuantity(productDto.getProductQuantity());
        }

        Product updatedProduct = productRepository.save(product);

        return productMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException
                                ("Product not found with given id : " + id));
        productRepository.deleteById(id);
    }
}
