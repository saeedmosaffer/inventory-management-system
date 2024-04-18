package edu.birzeit.saeedmosaffer.inventory_management_system.repository;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}