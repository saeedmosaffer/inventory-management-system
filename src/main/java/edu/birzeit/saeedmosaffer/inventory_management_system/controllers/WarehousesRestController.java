package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Warehouses;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.WarehousesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehousesRestController {
    private final WarehousesService warehousesService;

    public WarehousesRestController(WarehousesService warehousesService) {
        this.warehousesService = warehousesService;
    }

    @GetMapping
    public ResponseEntity<List<Warehouses>> getWarehouses(){
        List<Warehouses> warehouses = warehousesService.getWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouses> getWarehouseById(@PathVariable int id){
        Warehouses warehouse = warehousesService.getWarehouseById(id);
        if(warehouse != null) {
            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Warehouses> createWarehouse(@RequestBody Warehouses warehouse){
        Warehouses createdWarehouse = warehousesService.createWarehouse(warehouse);
        return new ResponseEntity<>(createdWarehouse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouses> updateWarehouse(@PathVariable int id, @RequestBody Warehouses warehouse) throws WarehousesService.WarehouseNotFoundException {
        Warehouses updatedWarehouse = warehousesService.updateWarehouse(id, warehouse);
        if(updatedWarehouse != null) {
            return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int id){
        boolean deleted = warehousesService.deleteWarehouse(id);
        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
