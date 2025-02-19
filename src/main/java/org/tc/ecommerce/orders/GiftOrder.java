package org.tc.ecommerce.orders;

import org.tc.ecommerce.Product;

import java.util.List;

public class GiftOrder extends Order{

    private String giftNote;

    public GiftOrder(List<Product> products, String giftNote) {
        super(products);
        this.giftNote = giftNote;
    }
}
