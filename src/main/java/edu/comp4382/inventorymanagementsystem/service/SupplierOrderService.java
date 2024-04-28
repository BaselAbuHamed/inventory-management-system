package edu.comp4382.inventorymanagementsystem.service;

import edu.comp4382.inventorymanagementsystem.dto.SupplierOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierOrderService {
SupplierOrderDto createSupplierOrder(SupplierOrderDto supplierOrderDto);

    SupplierOrderDto getSupplierOrderById(Long id);

    List<SupplierOrderDto> getAllSupplierOrders();

    SupplierOrderDto updateSupplierOrder(Long id, SupplierOrderDto supplierOrderDto);

    SupplierOrderDto patchSupplierOrder(Long id, SupplierOrderDto supplierOrderDto);

    void deleteSupplierOrder(Long id);
}
