package de.neuefische.orderdbserver.controller;

import de.neuefische.orderdbserver.model.Order;
import de.neuefische.orderdbserver.model.Product;
import de.neuefische.orderdbserver.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }
    @GetMapping
    public List<Order> getAllOrders(@RequestParam(required = false)String q) {
        return service.searchOrder(q);
    }
    @PutMapping
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }
}
