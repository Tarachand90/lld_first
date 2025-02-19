package org.tc.ecommerce;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class User {
    private String name;
    private String email;
    private Cart cart;
    private OrderService orderService;
    private Order order;

    public User(final String name, final String email, final Cart cart,
                final OrderService orderService) {
        this.name = name;
        this.email = email;
        this.cart = cart;
        this.orderService = orderService;
    }

    public  void addToCart(final Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(final Product product) {
        cart.removeProduct(product);
    }

    public void placeOrder() {
        order = new Order(cart.getProducts());
        orderService.addOrder(order, email);

        //then remove all the items from the cart
        cart.clear();
    }

    public void cancelOrder() {
        if(order != null && !order.isCanclled()) {
            orderService.removeOrder(order, email);
        }
    }

    public List<Order> getOrderHistory() {
        return orderService.getAllOrderDetails(email);
    }
}
