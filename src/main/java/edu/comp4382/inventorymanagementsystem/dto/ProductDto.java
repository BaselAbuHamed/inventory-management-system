package edu.comp4382.inventorymanagementsystem.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private Long productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private Date receivedDate;
    private String productNumber;
    private Long supplierId;
}
