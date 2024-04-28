package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @NotNull(message = "Order must be provided")
    private Order orderId;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "Quantity must be provided")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price must be provided")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @NotNull(message = "Product must be provided")
    private Product productId;
}
