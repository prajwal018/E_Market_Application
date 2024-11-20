package com.prajwal.ecommerce.mapper;

import com.prajwal.ecommerce.model.Payment;
import com.prajwal.ecommerce.record.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMapper {


    public Payment toPayment(PaymentRequest request) {

        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }
}
