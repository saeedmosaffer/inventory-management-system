package edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    Warehouse createWarehouse(Warehouse warehouse);

    Warehouse getWarehouseById(Long warehouseId);

    List<Warehouse> getAllWarehouses();

    Warehouse updateWarehouse(Warehouse warehouse);

    void deleteWarehouse(Long warehouseId);
}
