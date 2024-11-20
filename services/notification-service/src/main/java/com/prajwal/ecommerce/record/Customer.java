package com.prajwal.ecommerce.record;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
