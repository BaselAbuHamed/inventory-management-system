package edu.comp4382.inventorymanagementsystem.dto;

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
public class ProductDto {

    private Long productId;

    @NotBlank(message = "Product name is required")
    private String productName;

    @Positive(message = "Product price must be positive")
    private double productPrice;

    @Positive(message = "Product quantity must be positive")
    private int productQuantity;

    @NotNull(message = "Received date is required")
    private Date receivedDate;

    @NotBlank(message = "Product number is required")
    private String productNumber;

    @NotNull(message = "Supplier ID is required")
    private Long supplierId;
}
