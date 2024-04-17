package edu.comp4382.inventorymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class InventoryTransactionDto {

    private Long inventoryTransactionId;
    private Date transactionDate;
    private String transactionType;
    private int quantity;
    private Long productId;
}
