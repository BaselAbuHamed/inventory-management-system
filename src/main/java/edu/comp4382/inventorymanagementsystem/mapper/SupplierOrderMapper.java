package edu.comp4382.inventorymanagementsystem.mapper;

import edu.comp4382.inventorymanagementsystem.dto.SupplierOrderDto;
import edu.comp4382.inventorymanagementsystem.entity.Supplier;
import edu.comp4382.inventorymanagementsystem.entity.SupplierOrder;
import edu.comp4382.inventorymanagementsystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierOrderMapper {

    @Autowired
    public SupplierRepository supplierRepository;

    public SupplierOrderDto mapToSupplierOrderDto(SupplierOrder supplierOrder){
        return new SupplierOrderDto(supplierOrder.getSupplierOrderId(),
                supplierOrder.getSupplier().getSupplierId(),
                supplierOrder.getOrderDate(),
                supplierOrder.getExpectedDeliveryDate(),
                supplierOrder.getStatus()
        );
    }

    public SupplierOrder mapToSupplierOrder(SupplierOrderDto supplierOrderDto){

        SupplierOrder supplierOrder = new SupplierOrder();
        Supplier supplier = supplierRepository.findById(supplierOrderDto.getSupplierId())
                .orElseThrow(() ->
                        new RuntimeException
                                ("Supplier not found with given id : "
                                        +supplierOrderDto.getSupplierId()));

        supplierOrder.setOrderDate(supplierOrderDto.getOrderDate());
        supplierOrder.setSupplier(supplier);
        supplierOrder.setExpectedDeliveryDate(supplierOrderDto.getExpectedDeliveryDate());
        supplierOrder.setStatus(supplierOrderDto.getStatus());
        return supplierOrder;
    }
}
