package edu.comp4382.inventorymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User must be provided")
    private User user;

    @Column(name = "order_date" , nullable = false)
    @NotNull(message = "Order date must be provided")
    private Date orderDate;

    @Column(name = "total_amount" , nullable = false)
    @NotNull(message = "Total amount must be provided")
    private double totalAmount;
}
