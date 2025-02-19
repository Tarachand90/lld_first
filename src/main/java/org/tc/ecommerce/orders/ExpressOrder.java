package org.tc.ecommerce.orders;

import org.tc.ecommerce.Product;

import java.util.List;

public class ExpressOrder extends Order{
    private double priorityFee;

    public ExpressOrder(List<Product> products, double priorityFee) {
        super(products);
        this.priorityFee = priorityFee;
    }
}
