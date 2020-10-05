package de.neuefische.orderdbserver.db;

import de.neuefische.orderdbserver.model.Order;

import de.neuefische.orderdbserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDb {
    private final List<Order> orders = List.of(
            new Order ("Order1", List.of(new Product("Erbsen", "erbsenID", 99)
                    )));

    public List<Order> listOrders() {return orders;}
}
