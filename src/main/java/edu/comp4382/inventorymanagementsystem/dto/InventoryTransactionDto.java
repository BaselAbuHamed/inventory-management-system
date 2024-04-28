package edu.comp4382.inventorymanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryTransactionDto {

    private Long inventoryTransactionId;

    @NotNull(message = "Transaction date is required")
    private Timestamp transactionDate;

    @NotBlank(message = "Transaction type is required")
    private String transactionType;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    @NotNull(message = "Product ID is required")
    private Long productId;
}
