package org.tc.ecommerce;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart {
    private String cartId;
    private List<Product> products;

    public Cart() {
        
        this.cartId = UUID.randomUUID().toString(); // Auto-generate UUID as String
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

    public List<Product> viewCart() {
        return products;
    }
}
