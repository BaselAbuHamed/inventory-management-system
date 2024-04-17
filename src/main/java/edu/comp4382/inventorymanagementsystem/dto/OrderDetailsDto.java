package edu.comp4382.inventorymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetailsDto {

    private Long orderDetailsId;
    private Long orderId;
    private int quantity;
    private double price;
    private Long productId;
}
