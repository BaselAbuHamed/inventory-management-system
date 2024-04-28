package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.SupplierOrderDto;
import edu.comp4382.inventorymanagementsystem.service.SupplierOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {
    @Override
    public SupplierOrderDto createSupplierOrder(SupplierOrderDto supplierOrderDto) {
        return null;
    }

    @Override
    public SupplierOrderDto getSupplierOrderById(Long id) {
        return null;
    }

    @Override
    public List<SupplierOrderDto> getAllSupplierOrders() {
        return List.of();
    }

    @Override
    public SupplierOrderDto updateSupplierOrder(Long id, SupplierOrderDto supplierOrderDto) {
        return null;
    }

    @Override
    public SupplierOrderDto patchSupplierOrder(Long id, SupplierOrderDto supplierOrderDto) {
        return null;
    }

    @Override
    public void deleteSupplierOrder(Long id) {

    }
}
