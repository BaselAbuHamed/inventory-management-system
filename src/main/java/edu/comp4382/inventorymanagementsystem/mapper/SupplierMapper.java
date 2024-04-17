package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.SupplierDto;
import edu.comp4382.inventorymanagementsystem.entity.Supplier;
import edu.comp4382.inventorymanagementsystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierMapper {

    public SupplierDto mapToSupplierDto (Supplier supplier){
        return new SupplierDto(supplier.getSupplierId(),
                supplier.getSupplierName(),
                supplier.getContactPerson(),
                supplier.getPhone(),
                supplier.getEmail()
        );
    }

    public Supplier mapToSupplier (SupplierDto supplierDto){
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setContactPerson(supplierDto.getContactPerson());
        supplier.setPhone(supplierDto.getPhone());
        supplier.setEmail(supplierDto.getEmail());
        return supplier;
    }
}
