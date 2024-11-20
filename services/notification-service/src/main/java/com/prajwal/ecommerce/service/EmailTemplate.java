package com.prajwal.ecommerce.service;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    ORDER_CONFIRMATION("Order Confirmation", "order-confirmation.html"),
    PAYMENT_CONFIRMATION("Payment successfully processed", "payment-confirmation.html");

    private final String template;
    private final String subject;

    EmailTemplate(String subject, String template) {
        this.subject = subject;
        this.template = template;
    }
}
