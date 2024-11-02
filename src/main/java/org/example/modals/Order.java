package org.example.modals;

import java.util.ArrayList;
import java.util.List;
import org.example.modals.enums.OrderStatus;

public class Order {

    private int id;
    private List<OrderItem> items;
    private Table table;

    private OrderStatus status;

    public Order(int id, Table table) {
        this.id = id;
        this.table = table;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }


    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }
}
