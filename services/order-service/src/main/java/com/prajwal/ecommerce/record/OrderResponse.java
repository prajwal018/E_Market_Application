package com.prajwal.ecommerce.record;

import com.prajwal.ecommerce.model.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(

        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
