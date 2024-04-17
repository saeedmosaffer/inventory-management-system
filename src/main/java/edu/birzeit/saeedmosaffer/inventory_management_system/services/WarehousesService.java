package edu.birzeit.saeedmosaffer.inventory_management_system.services;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Warehouses;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class WarehousesService {

    private final Map<Integer, Warehouses> warehouses = new HashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger();

    public List<Warehouses> getWarehouses() {
        return new ArrayList<>(warehouses.values());
    }

    public Warehouses getWarehouseById(int id) {
        return warehouses.get(id);
    }

    public Warehouses createWarehouse(Warehouses warehouse) {
        int id = generateUniqueId();
        warehouse.setWarehouseID(id);
        warehouses.put(id, warehouse);
        return warehouse;
    }

    public Warehouses updateWarehouse(int id, Warehouses warehouse) throws WarehouseNotFoundException {
        if (warehouses.containsKey(id)) {
            warehouse.setWarehouseID(id);
            warehouses.put(id, warehouse);
            return warehouse;
        } else {
            throw new WarehouseNotFoundException("Warehouse with ID " + id + " not found");
        }
    }

    public boolean deleteWarehouse(int id) {
        return warehouses.remove(id) != null;
    }

    private int generateUniqueId() {
        return idCounter.incrementAndGet();
    }

    public class WarehouseNotFoundException extends Throwable {
        public WarehouseNotFoundException(String message) {
            super(message);
        }
    }
}
