package org.tc.ecommerce;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    private String orderId;
    private Date orderDate;
    private boolean isCanclled;
    private List<Product> products;

    public  Order(final List<Product> products) {
        this.orderId = UUID.randomUUID().toString(); // Auto-generate UUID as String
        this.orderDate = new Date();
        this.isCanclled = false;
        this.products = products;
    }

    public void cancelOrder() {
        this.isCanclled = true;
    }
}