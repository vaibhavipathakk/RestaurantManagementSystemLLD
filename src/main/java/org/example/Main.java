package org.example;

import java.util.List;
import org.example.modals.MenuItem;
import org.example.modals.Order;
import org.example.modals.OrderItem;
import org.example.modals.Table;
import org.example.modals.enums.Category;
import org.example.modals.enums.OrderStatus;
import org.example.modals.enums.PaymentMode;
import org.example.services.Restaurant;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to My Restaurant!");

        Restaurant restaurant = new Restaurant(5); // creating restaurant having 5 tables

        MenuItem item1 = new MenuItem("Veg Biryani", 250.00, true, Category.MAIN_COURSE);
        MenuItem item2 = new MenuItem("Chicken kebab", 300.00, false, Category.MAIN_COURSE);

        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);

        Table table = restaurant.getTables().get(0);
        List<OrderItem> orderItems = List.of(new OrderItem(item1, 2));
        Order order = restaurant.placeOrder(table, orderItems);

        System.out.println("Ordered Items : " + orderItems.stream().toList());

        order.setStatus(OrderStatus.PREPARING);
        System.out.println("Order Status : " + order.getStatus());
        order.setStatus(OrderStatus.COMPLETED);
        System.out.println("Order Status : " + order.getStatus());

        System.out.println("Final bill amount : " + restaurant.finalizeOrderPayment(order, PaymentMode.CARD));

    }
}