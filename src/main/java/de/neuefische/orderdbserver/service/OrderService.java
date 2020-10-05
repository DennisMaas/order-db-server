package de.neuefische.orderdbserver.service;

import de.neuefische.orderdbserver.db.OrderDb;
import de.neuefische.orderdbserver.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    private final OrderDb orderDb;
    @Autowired
    public OrderService(OrderDb orderDb){
        this.orderDb = orderDb;
    }
    public List<Order> listOrders(){
        return orderDb.listOrders();
    }
}
