package de.neuefische.orderdbserver.controller;

import de.neuefische.orderdbserver.model.Order;
import de.neuefische.orderdbserver.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return service.listOrders();
    }
}
