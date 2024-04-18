package edu.birzeit.saeedmosaffer.inventory_management_system.services.implementation;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Supplier;
import edu.birzeit.saeedmosaffer.inventory_management_system.repository.SupplierRepository;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        return optionalSupplier.orElse(null);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        Optional<Supplier> optionalExistingSupplier = supplierRepository.findById(supplier.getSupplierId());
        if (optionalExistingSupplier.isPresent()) {
            Supplier existingSupplier = optionalExistingSupplier.get();
            existingSupplier.setName(supplier.getName());
            existingSupplier.setContactInformation(supplier.getContactInformation());
            existingSupplier.setAddress(supplier.getAddress());
            existingSupplier.setPaymentTerms(supplier.getPaymentTerms());
            return supplierRepository.save(existingSupplier);
        }
        return null;
    }

    @Override
    public void deleteSupplier(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }
}
