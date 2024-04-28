package edu.comp4382.inventorymanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOrderDto {

    private Long supplierOrderId;

    @NotNull(message = "Supplier ID must be provided")
    private Long supplierId;

    @NotNull(message = "Order date must be provided")
    private Date orderDate;

    @NotNull(message = "Expected delivery date must be provided")
    private Date expectedDeliveryDate;

    @NotNull(message = "Status must be provided")
    private String status;
}
