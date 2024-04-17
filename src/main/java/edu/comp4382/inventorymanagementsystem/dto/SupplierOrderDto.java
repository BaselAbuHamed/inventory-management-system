package edu.comp4382.inventorymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SupplierOrderDto {

    private Long supplierOrderId;
    private Long supplierId;
    private Timestamp orderDate;
    private Date expectedDeliveryDate;
    private String status;
}
