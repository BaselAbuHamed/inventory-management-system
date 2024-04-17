package edu.comp4382.inventorymanagementsystem.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto {

    private Long orderId;
    private Long userId;
    private Date orderDate;
    private double totalAmount;
}
