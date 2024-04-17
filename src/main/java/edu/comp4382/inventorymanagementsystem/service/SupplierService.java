package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto createSupplier(SupplierDto supplierDto);

    SupplierDto getSupplierById(Long id);

    SupplierDto updateSupplier(Long id, SupplierDto supplierDto);

    SupplierDto patchSupplier(Long id, SupplierDto supplierDto);

    List<SupplierDto> getAllSuppliers();

    void deleteSupplier(Long id);

}
