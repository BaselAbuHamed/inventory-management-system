package edu.comp4382.inventorymanagementsystem.repository;

import edu.comp4382.inventorymanagementsystem.entity.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {
}
