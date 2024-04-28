package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.InventoryTransactionDto;
import edu.comp4382.inventorymanagementsystem.entity.InventoryTransaction;
import edu.comp4382.inventorymanagementsystem.entity.Product;
import edu.comp4382.inventorymanagementsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class InventoryTransactionMapper {

    private final ProductRepository productRepository;

    @Autowired
    public InventoryTransactionMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public InventoryTransactionDto mapToInventoryTransactionDto(InventoryTransaction inventoryTransaction) {
        return new InventoryTransactionDto(inventoryTransaction.getInventoryTransactionId(),
                inventoryTransaction.getTransactionDate(),
                inventoryTransaction.getTransactionType(),
                inventoryTransaction.getQuantity(),
                inventoryTransaction.getProductId().getProductId()
        );
    }

    public InventoryTransaction mapToInventoryTransaction(InventoryTransactionDto inventoryTransactionDto) {
        InventoryTransaction inventoryTransaction = new InventoryTransaction();
        Product product = productRepository.findById(inventoryTransactionDto.getProductId()).
                orElseThrow(() -> new RuntimeException(
                        "Product not found with given id : " + inventoryTransactionDto.getProductId()));
        inventoryTransaction.setInventoryTransactionId(inventoryTransactionDto.getInventoryTransactionId());
        inventoryTransaction.setTransactionDate(inventoryTransactionDto.getTransactionDate());
        inventoryTransaction.setTransactionType(inventoryTransactionDto.getTransactionType());
        inventoryTransaction.setQuantity(inventoryTransactionDto.getQuantity());
        inventoryTransaction.setProductId(product);
        return inventoryTransaction;
    }
}
