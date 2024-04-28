package edu.comp4382.inventorymanagementsystem.service.impl;

import edu.comp4382.inventorymanagementsystem.dto.SupplierDto;
import edu.comp4382.inventorymanagementsystem.entity.Supplier;
import edu.comp4382.inventorymanagementsystem.exception.ResourceNotFoundException;
import edu.comp4382.inventorymanagementsystem.mapper.SupplierMapper;
import edu.comp4382.inventorymanagementsystem.repository.SupplierRepository;
import edu.comp4382.inventorymanagementsystem.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;
    SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = supplierMapper.mapToSupplier(supplierDto);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.mapToSupplierDto(savedSupplier);
    }

    @Override
    public SupplierDto getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException
                                ("Supplier not found with given id : " + id));
        return supplierMapper.mapToSupplierDto(supplier);
    }

    @Override
    public SupplierDto updateSupplier(Long id, SupplierDto supplierDto) {
        Supplier supplier = supplierRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException
                                ("Supplier not found with given id : " + id));

        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setContactPerson(supplierDto.getContactPerson());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPhone(supplierDto.getPhone());

        Supplier updatedSupplier = supplierRepository.save(supplier);
        return supplierMapper.mapToSupplierDto(updatedSupplier);
    }

    @Override
    public SupplierDto patchSupplier(Long id, SupplierDto supplierDto) {

        Supplier supplier = supplierRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException
                                ("Supplier not found with given id : " + id));

        if (supplierDto.getSupplierName() != null) {
            supplier.setSupplierName(supplierDto.getSupplierName());
        }
        if (supplierDto.getContactPerson() != null) {
            supplier.setContactPerson(supplierDto.getContactPerson());
        }
        if (supplierDto.getEmail() != null) {
            supplier.setEmail(supplierDto.getEmail());
        }
        if (supplierDto.getPhone() != null) {
            supplier.setPhone(supplierDto.getPhone());
        }

        Supplier updatedSupplier = supplierRepository.save(supplier);
        return supplierMapper.mapToSupplierDto(updatedSupplier);
    }

    @Override
    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDto> supplierDto = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            supplierDto.add(supplierMapper.mapToSupplierDto(supplier));
        }
        return supplierDto;
    }

    @Override
    public void deleteSupplier(Long id) {

        //updated
        if (!supplierRepository.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found with given id : " + id);
        }

        try {
            supplierRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Supplier not found with given id : " + id);
        }
    }
}
