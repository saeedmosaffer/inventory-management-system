package edu.birzeit.saeedmosaffer.inventory_management_system.services;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Orders;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrdersService {

    private final Map<Integer, Orders> orders = new HashMap<>();
    private static final AtomicLong idCounter = new AtomicLong();

    public List<Orders> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public Orders getOrderById(int id) {
        return orders.get(id);
    }

    public Orders createOrder(Orders order) {
        int id = generateUniqueId();
        order.setOrderID(id);
        orders.put(id, order);
        return order;
    }

    public Orders updateOrder(int id, Orders order) throws OrderNotFoundException {
        if (orders.containsKey(id)) {
            order.setOrderID(id);
            orders.put(id, order);
            return order;
        } else {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
    }

    public boolean deleteOrder(int id) {
        return orders.remove(id) != null;
    }

    private int generateUniqueId() {
        return (int) idCounter.incrementAndGet();
    }

    public class OrderNotFoundException extends Throwable {
        public OrderNotFoundException(String message) {
            super(message);
        }
    }
}
