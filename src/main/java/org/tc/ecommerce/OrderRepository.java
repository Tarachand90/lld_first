package org.tc.ecommerce;

import org.tc.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private Map<String, List<Order>> orderMap;

    public OrderRepository() {
        orderMap = new HashMap<>();
    }

    public void saveOrder(final Order order, final String email) {
        List<Order> orderList = orderMap.computeIfAbsent(email, k -> new ArrayList<>());
        orderList.add(order);
    }

    public void cancelOrder(Order order, String email) {
        List<Order> orderList = orderMap.get(email);
        if(orderList == null) {
            throw  new IllegalArgumentException("Invalid email id");
       }

        // Remove the order from the list
       boolean removed = orderList.removeIf(existingOrder -> existingOrder.equals(order));

        if(!removed) {
            throw new IllegalArgumentException("Order not found for cancellation");
        }
    }

    public List<Order> getOrdersDetailsForSpecificEmail(final String email) {
        List<Order> orderList = orderMap.get(email);
        if(orderList == null) {
            throw  new IllegalArgumentException("Invalid email id");
        }
        return List.copyOf(orderList);
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        for(List<Order> orders : orderMap.values()) {
            allOrders.addAll(orders);
        }

        return allOrders;
    }
}
