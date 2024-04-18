package edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);

    Supplier getSupplierById(Long supplierId);

    List<Supplier> getAllSuppliers();

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Long supplierId);
}
