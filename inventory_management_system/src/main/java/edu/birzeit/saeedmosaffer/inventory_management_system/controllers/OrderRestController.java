package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Order;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderRestController {

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order savedOrder = orderService.createOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId){
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long orderId,
                                             @RequestBody Order order){
        order.setOrderId(orderId);
        Order updatedOrder = orderService.updateOrder(order);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>("Order successfully deleted!", HttpStatus.OK);
    }
}
