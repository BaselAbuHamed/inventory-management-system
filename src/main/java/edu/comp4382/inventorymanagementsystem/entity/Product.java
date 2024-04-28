package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be positive")
    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @NotNull(message = "Product quantity is required")
    @Positive(message = "Product quantity must be positive")
    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @NotNull(message = "Received date is required")
    @Column(name = "received_date", nullable = false)
    private Date receivedDate;

    @NotBlank(message = "Product number is required")
    @Column(name = "product_number", nullable = false)
    private String productNumber;

    @NotNull(message = "Supplier is required")
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplierId;
}
