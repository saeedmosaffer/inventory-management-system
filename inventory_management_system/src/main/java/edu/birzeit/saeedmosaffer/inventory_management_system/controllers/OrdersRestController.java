package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Orders;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {
    private final OrdersService ordersService;

    public OrdersRestController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getOrders(){
        List<Orders> orders = ordersService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id){
        Orders order = ordersService.getOrderById(id);
        if(order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order){
        Orders createdOrder = ordersService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int id, @RequestBody Orders order) throws OrdersService.OrderNotFoundException {
        Orders updatedOrder = ordersService.updateOrder(id, order);
        if(updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id){
        boolean deleted = ordersService.deleteOrder(id);
        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
