package edu.comp4382.inventorymanagementsystem.repository;

import edu.comp4382.inventorymanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
