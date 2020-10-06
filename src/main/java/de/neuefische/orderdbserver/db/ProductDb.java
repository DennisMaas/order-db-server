package de.neuefische.orderdbserver.db;

import de.neuefische.orderdbserver.model.Product;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductDb {
    private final List<Product> products = new ArrayList<>(List.of(
            new Product("Erbsen", "erbsenID", 99, 500),
            new Product("Bohnen", "bohnenID", 129, 1000)));



    public List<Product> listProducts(){
        return products;
    }

    public List<Product> searchProducts(String q){
        List<Product> searchList = new ArrayList<>();
        String lowerCaseQ = q.toLowerCase();
        for (Product product: products){

                if (product.getName().toLowerCase().contains(lowerCaseQ)) {
                    searchList.add(product);
                }

        }
        return searchList;
    }


    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }
}