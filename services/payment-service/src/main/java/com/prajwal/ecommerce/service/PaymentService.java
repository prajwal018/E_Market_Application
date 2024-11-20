package com.prajwal.ecommerce.service;

import com.prajwal.ecommerce.kafka.PaymentConfirmation;
import com.prajwal.ecommerce.kafka.PaymentProducer;
import com.prajwal.ecommerce.mapper.PaymentMapper;
import com.prajwal.ecommerce.record.PaymentRequest;
import com.prajwal.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final PaymentProducer paymentProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        paymentProducer.sendPaymentConfirmation(
                new PaymentConfirmation(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );

        return payment.getId();
    }
}
