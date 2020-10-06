package de.neuefische.orderdbserver.controller;

import de.neuefische.orderdbserver.model.Product;
import de.neuefische.orderdbserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController (ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false)String q){
        return service.listProducts(q);

    }
    @PutMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

}
