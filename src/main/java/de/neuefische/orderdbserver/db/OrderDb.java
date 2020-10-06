package de.neuefische.orderdbserver.db;

import de.neuefische.orderdbserver.model.Order;

import de.neuefische.orderdbserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {
    private final List<Order> orders = new ArrayList<>(List.of(
            new Order ("Order1", List.of(new Product("Erbsen", "erbsenID", 99, 100)
            ))));

    public List<Order> listOrders() {
        return orders;
    }

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> searchOrder(String q) {
        List<Order> searchOrder = new ArrayList<>();
        String lowerCaseQ = q.toLowerCase();
        for (Order order: orders){

            if (order.getId().toLowerCase().contains(lowerCaseQ)){
                searchOrder.add(order);
            }
        }
        return searchOrder;

    }
}
