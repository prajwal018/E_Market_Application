package com.prajwal.ecommerce.record;

import com.prajwal.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(

        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
