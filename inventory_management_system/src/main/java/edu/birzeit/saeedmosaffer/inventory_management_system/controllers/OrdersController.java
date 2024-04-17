package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Orders;
import edu.birzeit.saeedmosaffer.inventory_management_system.models.Products;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public String getOreders(Model model){
        List<Orders> orders = ordersService.getOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
