package de.neuefische.orderdbserver.controller;

import de.neuefische.orderdbserver.model.Product;
import de.neuefische.orderdbserver.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    private final ProductService service = mock(ProductService.class);
    private final ProductController productController = new ProductController(service);

    @Test
    public void getProductByNameShouldReturnMatchingProduct(){
        //GIVEN
        String productName = "some-product-Name";

        List<Product> returnValue = List.of(new Product(
                productName,
                        "some Product name", 20, 200
        ));
        when(service.listProducts(productName)).thenReturn(returnValue);

        //WHEN
        List<Product> products = productController.getAllProducts(productName);

        //THEN
        assertThat(products, containsInAnyOrder(new Product(
                productName,
                    "some Product name", 20, 200
        )));
    }

    @Test
    public void addProductShouldAddProductToDb(){
        //GIVEN
        Product product = new Product("Zwiebel", "123",50,60);
        when(service.addProduct(product)).thenReturn(product);

        //WHEN
        Product actualProduct = productController.addProduct(product);

        //THEN
        assertThat(actualProduct, is(new Product("Zwiebel", "123",50,60)));
    }
}