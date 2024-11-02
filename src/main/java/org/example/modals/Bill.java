package org.example.modals;

public class Bill {
    private Order order;

    private double taxRate;
    private double serviceCharge;
    private double additionalCharge;


    public Bill(Order order) {
        this.order = order;
        this.taxRate = 0.1;  // 10% tax
        this.serviceCharge = 0.05;  // 5% service charge
        this.additionalCharge = 0;
    }


    public void applyCardCharges() {
        additionalCharge = 0.02 * order.calculateTotal(); // Additional 2% charge for card
    }


    public double calculateFinalAmount() {
        double subtotal = order.calculateTotal();
        return subtotal + (subtotal * taxRate) + (subtotal * serviceCharge) + additionalCharge;
    }
}
