package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "supplier_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierOrderId;

    @NotNull(message = "Supplier must be provided")
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @NotNull(message = "Order date must be provided")
    @Column(name = "order_date")
    private Date orderDate;

    @NotNull(message = "Expected delivery date must be provided")
    @Column(name = "expected_delivery_date")
    private Date expectedDeliveryDate;

    @NotNull(message = "Status must be provided")
    @Column(name = "status", nullable = false)
    private String status;
}
