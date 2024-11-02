package org.example.modals;

import org.example.modals.enums.PaymentMode;

public class Payment {
    private PaymentMode paymentMode;

    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    // Process payment based on payment mode
    public double processPayment(Bill bill) {
        if (paymentMode == PaymentMode.CARD) {
            bill.applyCardCharges(); // Apply extra charge for card payments
        }

        return bill.calculateFinalAmount(); // Return the final bill amount
    }
}
