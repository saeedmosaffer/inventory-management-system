package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Warehouse;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/warehouses")
public class WarehouseRestController {

    private WarehouseService warehouseService;

    // create Warehouse REST API
    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse){
        Warehouse savedWarehouse = warehouseService.createWarehouse(warehouse);
        return new ResponseEntity<>(savedWarehouse, HttpStatus.CREATED);
    }

    // get warehouse by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable("id") Long warehouseId){
        Warehouse warehouse = warehouseService.getWarehouseById(warehouseId);
        if (warehouse != null) {
            return new ResponseEntity<>(warehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // get all warehouses REST API
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses(){
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }

    // update Warehouse REST API
    @PutMapping("{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable("id") Long warehouseId,
                                                     @RequestBody Warehouse warehouse){
        warehouse.setWarehouseId(warehouseId);
        Warehouse updatedWarehouse = warehouseService.updateWarehouse(warehouse);
        if (updatedWarehouse != null) {
            return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete Warehouse REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable("id") Long warehouseId){
        warehouseService.deleteWarehouse(warehouseId);
        return new ResponseEntity<>("Warehouse successfully deleted!", HttpStatus.OK);
    }
}
