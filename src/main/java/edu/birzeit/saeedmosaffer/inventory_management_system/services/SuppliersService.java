package edu.birzeit.saeedmosaffer.inventory_management_system.services;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Suppliers;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SuppliersService {

    private final Map<Integer, Suppliers> suppliers = new HashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger();

    public List<Suppliers> getSuppliers() {
        return new ArrayList<>(suppliers.values());
    }

    public Suppliers getSupplierById(int id) {
        return suppliers.get(id);
    }

    public Suppliers createSupplier(Suppliers supplier) {
        int id = generateUniqueId();
        supplier.setSupplierID(id);
        suppliers.put(id, supplier);
        return supplier;
    }

    public Suppliers updateSupplier(int id, Suppliers supplier) throws SupplierNotFoundException {
        if (suppliers.containsKey(id)) {
            supplier.setSupplierID(id);
            suppliers.put(id, supplier);
            return supplier;
        } else {
            throw new SupplierNotFoundException("Supplier with ID " + id + " not found");
        }
    }

    public boolean deleteSupplier(int id) {
        return suppliers.remove(id) != null;
    }

    private int generateUniqueId() {
        return idCounter.incrementAndGet();
    }

    public class SupplierNotFoundException extends Throwable {
        public SupplierNotFoundException(String message) {
            super(message);
        }
    }
}
