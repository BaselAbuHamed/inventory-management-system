package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.InventoryTransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InventoryTransactionService {
    InventoryTransactionDto createInventoryTransaction(InventoryTransactionDto inventoryTransactionDto);

    InventoryTransactionDto getInventoryTransactionById(Long id);

    List<InventoryTransactionDto> getAllInventoryTransactions();

    InventoryTransactionDto updateInventoryTransaction(Long id, InventoryTransactionDto inventoryTransactionDto);

    void deleteInventoryTransaction(Long id);
}