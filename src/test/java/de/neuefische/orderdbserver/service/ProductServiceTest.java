package de.neuefische.orderdbserver.service;

import de.neuefische.orderdbserver.db.ProductDb;
import de.neuefische.orderdbserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private final ProductDb productDb = mock(ProductDb.class);
    private final ProductService productService = new ProductService(productDb);

    @Test
    void listProductsForRequestParamNullShouldReturnProductList() {
        //GIVEN
        List<Product> productList = new ArrayList<>(List.of(
                new Product ("SomeName", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)));

        String q = null;

        when(productService.listProducts(q)).thenReturn(productList);

        //WHEN
        List<Product> actualList = productService.listProducts(q);

        //THEN
        assertThat(actualList, is(new ArrayList<>(List.of(
                new Product ("SomeName", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)))));
    }

    @Test
    void listProductsForRequestParamBlankShouldReturnProductList() {
        //GIVEN
        List<Product> productList = new ArrayList<>(List.of(
                new Product ("SomeName", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)));

        String q = " ";

        when(productService.listProducts(q)).thenReturn(productList);

        //WHEN
        List<Product> actualList = productService.listProducts(q);

        //THEN
        assertThat(actualList, is(new ArrayList<>(List.of(
                new Product ("SomeName", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)))));
    }

    @Test
    void listProductsForRequestParamShouldVerifySearch() {
        //GIVEN
        List<Product> productList = new ArrayList<>(List.of(
                new Product ("Lappen", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)));

        String q = "SomeName";

        when(productDb.searchProducts(q)).thenReturn(productList);

        //WHEN
        List<Product> actualList = productService.listProducts(q);

        //THEN
        assertThat(actualList, containsInAnyOrder(
                new Product ("Lappen", "SomeString", 23, 2),
                new Product ("SomeName2", "SomeString2", 232, 22)));

        verify(productDb).searchProducts(q);
    }



}

























