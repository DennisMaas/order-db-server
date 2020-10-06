package de.neuefische.orderdbserver.db;

import de.neuefische.orderdbserver.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductDbTest {

    @Test
    void searchProductsForRequestParamSomeNameShouldReturnSearchList() {
        //GIVEN
        ProductDb productDb = new ProductDb();

        String q = "Erbsen";

        //WHEN
        List<Product> actualList = productDb.searchProducts(q);

        //THEN
        assertThat(actualList, is(new ArrayList<>(List.of(
                new Product("Erbsen", "erbsenID", 99, 500)))));
    }

}