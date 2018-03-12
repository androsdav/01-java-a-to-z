package com.adidyk;

/**
 * Class Product for create product (object) with params: id, name.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.03.2018.
 * @version 1.0.
 */
public class Product {

    /**
     * @param id - product id.
     */
    private final String id;

    /**
     * @param name - product name.
     */
    private String name;

    /**
     * Product - constructor.
     * @param id - product id.
     * @param name - product name.
     */
    Product(final String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class Product.
     * @return - returns boolean result "true" if id of product and name of product is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return this.id.equals(product.id) && this.name.equals(product.name);
    }

    /**
     * hashCode - returns hashCode for product.
     * @return - returns hashCode for product.
     */
    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for product.
     */
    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "Product{", "id=", this.id, "; name=", this.name, "}");
    }

}