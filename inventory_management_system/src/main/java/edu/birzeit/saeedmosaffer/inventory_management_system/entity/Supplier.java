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
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactInformation;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String paymentTerms;
}
