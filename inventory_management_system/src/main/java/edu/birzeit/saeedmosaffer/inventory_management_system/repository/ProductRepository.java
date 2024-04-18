package edu.birzeit.saeedmosaffer.inventory_management_system.repository;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
