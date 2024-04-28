package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.ProductDto;
import edu.comp4382.inventorymanagementsystem.entity.Product;
import edu.comp4382.inventorymanagementsystem.entity.Supplier;
import edu.comp4382.inventorymanagementsystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class ProductMapper {

    private final SupplierRepository supplierRepository;

    @Autowired
    public ProductMapper(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQuantity(),
                product.getReceivedDate(),
                product.getProductNumber(),
                product.getSupplierId().getSupplierId()
        );
    }

    public Product mapToProduct(ProductDto productDto) {

        Product product = new Product();
        Supplier supplier = supplierRepository.findById(productDto.getSupplierId())
                .orElseThrow(() ->
                        new RuntimeException
                                ("Supplier not found with given id : "
                                        + productDto.getSupplierId()));

        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductQuantity(productDto.getProductQuantity());
        product.setReceivedDate(Timestamp.valueOf(LocalDateTime.now()));
        product.setProductNumber(productDto.getProductNumber());
        product.setSupplierId(supplier);
        return product;
    }
}
