package edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}