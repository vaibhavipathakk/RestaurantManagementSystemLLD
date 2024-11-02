package org.example.services;

import java.util.ArrayList;
import java.util.List;
import org.example.modals.Bill;
import org.example.modals.Order;
import org.example.modals.OrderItem;
import org.example.modals.Payment;
import org.example.modals.Table;
import org.example.modals.MenuItem;
import org.example.modals.enums.OrderStatus;
import org.example.modals.enums.PaymentMode;

public class Restaurant {

    private final List<Table> tables;
    private List<MenuItem> menu;
    private List<Order> orders;

    private int nextOrderNumber;

    public Restaurant(int numTables) {
        tables = new ArrayList<>();
        menu = new ArrayList<>();
        orders = new ArrayList<>();
        nextOrderNumber = 1; //next order number

        for (int i = 0; i < numTables; ++i ) {
            Table table = new Table(i++, true);
            tables.add(table);
        }
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menu.add(menuItem);
    }

    public void updateMenuItem(String name, double newItemPrice) {
        this.menu.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .ifPresent(menuItem -> {
                    menuItem.setPrice(newItemPrice);
                });
    }

    public void removeMenuItem(String name) {
        this.menu.removeIf(item -> item.getName().equals(name));
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getNextOrderNumber() {
        return nextOrderNumber;
    }

    // Order Operations
    public Order placeOrder(Table table, List<OrderItem> items) {
        Order order = new Order(nextOrderNumber++, table);
        System.out.println("Order Status : " + order.getStatus());
        for (OrderItem item : items) {
            order.addItem(item);
        }
        orders.add(order);
        return order;
    }

    public double finalizeOrderPayment(Order order, PaymentMode paymentMode) {
        Bill bill = new Bill(order);
        Payment payment = new Payment(paymentMode);
        return payment.processPayment(bill);
    }

}
