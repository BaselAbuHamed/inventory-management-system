package edu.comp4382.inventorymanagementsystem.controller;

import edu.comp4382.inventorymanagementsystem.dto.SupplierDto;
import edu.comp4382.inventorymanagementsystem.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    //Build Add Supplier Rest API
    @PostMapping
    public ResponseEntity<SupplierDto> createSupplier(@Valid @RequestBody SupplierDto supplierDto) {
        SupplierDto savedSupplier = supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    //Build Get Supplier By Id Rest API
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable Long id) {
        SupplierDto supplier = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    //Build Get All Suppliers Rest API
    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        List<SupplierDto> suppliers = supplierService.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    //Build Update Supplier Rest API
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable("id") Long id, @RequestBody SupplierDto supplierDto) {
        SupplierDto updatedSupplier = supplierService.updateSupplier(id, supplierDto);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }

    //Build Patch Supplier Rest API
    @PatchMapping("/{id}")
    public ResponseEntity<SupplierDto> patchSupplier(@PathVariable("id") Long id, @RequestBody SupplierDto supplierDto) {
        SupplierDto updatedSupplier = supplierService.patchSupplier(id, supplierDto);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }

    //Build Delete Supplier Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully.");
    }

}
