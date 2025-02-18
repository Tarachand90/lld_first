package org.tc.ecommerce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    private int cartId;
    private List<Product> products;

    public Cart() {
        this.cartId = 1; //hardcoded right now, it will be fetch from db with card sequence
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void clear() {
        products.clear();
    }
}
