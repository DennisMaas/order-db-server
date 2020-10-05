package de.neuefische.orderdbserver.db;

import de.neuefische.orderdbserver.model.Product;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class ProductDb {
    private final List<Product> products = List.of(
            new Product("Erbsen", "erbsenID", 99, 500),
            new Product("Bohnen", "bohnenID", 129, 1000));

    public List<Product> listProducts(){
        return products;
    }


}
