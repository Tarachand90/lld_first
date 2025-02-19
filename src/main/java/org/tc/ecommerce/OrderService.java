package org.tc.ecommerce;


import java.util.List;

public class OrderService {

    private OrderRepository repository;

    public OrderService() {
        this.repository = new OrderRepository();
    }

    public void addOrder(final Order order, final String email) {
        repository.saveOrder(order, email);
    }

    public void removeOrder(final Order order, final String email) {
        repository.cancelOrder(order, email);
        order.setCanclled(true);
    }

    public List<Order> getAllOrderDetails(final String email) {
        return repository.getOrdersDetailsForSpecificEmail(email);
    }

    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }
}
