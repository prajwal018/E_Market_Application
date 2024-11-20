package com.prajwal.ecommerce.kafka;

import com.prajwal.ecommerce.model.PaymentMethod;
import com.prajwal.ecommerce.record.CustomerResponse;
import com.prajwal.ecommerce.record.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
