package org.tc.ecommerce.users;

import org.tc.ecommerce.Cart;
import org.tc.ecommerce.orders.Order;
import org.tc.ecommerce.OrderService;
import org.tc.ecommerce.Product;

import java.util.List;

public class CustomerUser extends User {

    private Cart cart;
    private OrderService orderService;
    private Order order;

    public CustomerUser(final String name, final String email, final Cart cart,
                final OrderService orderService) {
        super(name, email);
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
        if(cart == null || cart.getProducts().isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return;
        }
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
