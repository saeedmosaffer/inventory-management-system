package edu.birzeit.saeedmosaffer.inventory_management_system.services.implementation;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Order;
import edu.birzeit.saeedmosaffer.inventory_management_system.repository.OrderRepository;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> optionalExistingOrder = orderRepository.findById(order.getOrderId());
        if (optionalExistingOrder.isPresent()) {
            Order existingOrder = optionalExistingOrder.get();
            existingOrder.setCustomerId(order.getCustomerId());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setDeliveryDate(order.getDeliveryDate());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setTotalAmount(order.getTotalAmount());
            existingOrder.setPaymentStatus(order.getPaymentStatus());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
