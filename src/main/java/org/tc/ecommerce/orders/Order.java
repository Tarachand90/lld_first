package org.tc.ecommerce.orders;

import lombok.*;
import org.tc.ecommerce.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    protected String orderId;
    protected Date orderDate;
    protected boolean isCanclled;
    protected List<Product> products;

    public  Order(final List<Product> products) {
        this.orderId = UUID.randomUUID().toString(); // Auto-generate UUID as String
        //Creating orderId with UUID has below cons:
        //1: UUIDs are random, leading to non-sequential storage in the database
        //causing slower lookup and index maintenacce

        //2: it takes 16 bytes: more than int(4 bytes) or long(8 bytes)
        this.orderDate = new Date();
        this.isCanclled = false;
        this.products = products;
    }

    public void cancelOrder() {
        this.isCanclled = true;
    }
}