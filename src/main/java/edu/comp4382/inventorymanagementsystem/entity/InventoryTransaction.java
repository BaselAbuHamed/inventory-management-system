package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "inventory_transaction")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryTransactionId;

    @Column(name = "transaction_date")
    @NotNull(message = "Transaction date must be provided")
    private Timestamp transactionDate;

    @Column(name = "transaction_type")
    @NotNull(message = "Transaction type must be provided")
    private String transactionType;

    @Column(name = "quantity" )
    @NotNull(message = "Quantity must be provided")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @NotNull(message = "Product must be provided")
    private Product productId;

}
