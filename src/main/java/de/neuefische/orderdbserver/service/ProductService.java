package de.neuefische.orderdbserver.service;

import de.neuefische.orderdbserver.db.ProductDb;
import de.neuefische.orderdbserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> listProducts(String q){
        if (q == null || q.isBlank()) {
            return productDb.listProducts();
        }
        return productDb.searchProducts(q);

    }

    public Product addProduct(Product product) {
        return productDb.addProduct(product);
    }
}
