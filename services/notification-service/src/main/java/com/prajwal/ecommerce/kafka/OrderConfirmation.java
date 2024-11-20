package com.prajwal.ecommerce.kafka;

import com.prajwal.ecommerce.model.PaymentMethod;
import com.prajwal.ecommerce.record.Customer;
import com.prajwal.ecommerce.record.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}