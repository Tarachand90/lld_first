package org.tc.ecommerce.users;

import org.tc.ecommerce.Order;
import org.tc.ecommerce.OrderService;

public class AdminUser extends User{

    private OrderService orderService;

    public AdminUser(final String name, final String email, final OrderService orderService) {
        super(name, email);
        this.orderService = orderService;
    }

    /**
     * View all orders in the system (admin privilege).
     */
    public void viewAllOrders() {
        // In a real system, you'd fetch all orders from the repository.
        System.out.println("Viewing all orders (Admin privilege).");
        orderService.getAllOrders()
                .forEach(System.out :: println);
    }

    /**
     * Cancel any order by order ID and user email (admin privilege).
     * @param order The order to be canceled.
     * @param userEmail The email of the user whose order needs to be canceled.
     */
    public void cancelOrderForUser(Order order, String userEmail) {
        if (order == null || userEmail == null || userEmail.isEmpty()) {
            System.out.println("Invalid order or user email.");
            return;
        }
        try {
            orderService.removeOrder(order, userEmail);
            System.out.println("Admin canceled the order for user: " + userEmail);
        } catch (IllegalArgumentException e) {
            System.err.println("Error canceling order: " + e.getMessage());
        }
    }

}
