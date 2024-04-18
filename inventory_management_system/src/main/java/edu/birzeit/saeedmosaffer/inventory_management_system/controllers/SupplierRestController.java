package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Supplier;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/suppliers")
public class SupplierRestController {

    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
        Supplier savedSupplier = supplierService.createSupplier(supplier);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") Long supplierId){
        Supplier supplier = supplierService.getSupplierById(supplierId);
        if (supplier != null) {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") Long supplierId,
                                                   @RequestBody Supplier supplier){
        supplier.setSupplierId(supplierId);
        Supplier updatedSupplier = supplierService.updateSupplier(supplier);
        if (updatedSupplier != null) {
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long supplierId){
        supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>("Supplier successfully deleted!", HttpStatus.OK);
    }
}
