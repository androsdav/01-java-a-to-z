package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ProductTest does testing of class User.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class ProductTest {

    /**
     * productTest - test method equals class Product.
     */
    @Test
    public void equalsTest() {
        final Product product1 = new Product("1", "book");
        final Product product2 = new Product("1", "book");
        assertThat(product1, is(product2));
    }

}