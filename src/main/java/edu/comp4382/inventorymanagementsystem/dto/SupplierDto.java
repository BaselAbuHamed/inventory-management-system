package edu.comp4382.inventorymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SupplierDto {

    private Long supplierId;
    private String supplierName;
    private String contactPerson;
    private String phone;
    private String email;
}
