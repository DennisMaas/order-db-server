package de.neuefische.orderdbserver.controller;

import de.neuefische.orderdbserver.model.Product;
import de.neuefische.orderdbserver.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

class ProductControllerTest {

    private final ProductService service = mock(ProductService.class);
    private final ProductController productController = new ProductController(service);

    @Test
    public void getProductByIdShouldReturnMatchingProduct(){
        //GIVEN
        String productId = "some-product-Id";

        Optional<Product> returnValue = Optional.of(new Product(
                productId,
                        "some Product name"
        ));

        //WHEN
        Product product = productController.getAllProducts(productId);

        //THEN
        assertThat(product, is(new Product(
                productId,
                    "some Product name"
        )));
    }

}