package org.tc.ecommerce;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    private int orderId;
    private Date orderDate;
    private boolean isCanclled;
    private List<Product> products;

    public  Order(final List<Product> products) {
        this.orderId = 1; //hardcoded for time being
        this.orderDate = new Date();
        this.isCanclled = false;
        this.products = products;
    }

    public void cancelOrder() {
        this.isCanclled = true;
    }
}