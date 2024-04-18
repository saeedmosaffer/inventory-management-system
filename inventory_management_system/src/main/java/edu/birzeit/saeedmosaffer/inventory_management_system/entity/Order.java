package edu.birzeit.saeedmosaffer.inventory_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private String deliveryDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private String paymentStatus;
}
