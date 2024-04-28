package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.InventoryTransactionDto;
import edu.comp4382.inventorymanagementsystem.service.InventoryTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionServiceImpl implements InventoryTransactionService {
    @Override
    public InventoryTransactionDto createInventoryTransaction(InventoryTransactionDto inventoryTransactionDto) {
        return null;
    }

    @Override
    public InventoryTransactionDto getInventoryTransactionById(Long id) {
        return null;
    }

    @Override
    public List<InventoryTransactionDto> getAllInventoryTransactions() {
        return List.of();
    }

    @Override
    public InventoryTransactionDto updateInventoryTransaction(Long id, InventoryTransactionDto inventoryTransactionDto) {
        return null;
    }

    @Override
    public void deleteInventoryTransaction(Long id) {

    }
}
