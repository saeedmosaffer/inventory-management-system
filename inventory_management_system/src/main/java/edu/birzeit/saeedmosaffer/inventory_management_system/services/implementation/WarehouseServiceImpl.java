package edu.birzeit.saeedmosaffer.inventory_management_system.services.implementation;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Warehouse;
import edu.birzeit.saeedmosaffer.inventory_management_system.repository.WarehouseRepository;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse getWarehouseById(Long warehouseId) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
        return optionalWarehouse.orElse(null);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        Optional<Warehouse> optionalExistingWarehouse = warehouseRepository.findById(warehouse.getWarehouseId());
        if (optionalExistingWarehouse.isPresent()) {
            Warehouse existingWarehouse = optionalExistingWarehouse.get();
            existingWarehouse.setName(warehouse.getName());
            existingWarehouse.setLocation(warehouse.getLocation());
            existingWarehouse.setCapacity(warehouse.getCapacity());
            existingWarehouse.setManagerId(warehouse.getManagerId());
            return warehouseRepository.save(existingWarehouse);
        }
        return null;
    }

    @Override
    public void deleteWarehouse(Long warehouseId) {
        warehouseRepository.deleteById(warehouseId);
    }
}
