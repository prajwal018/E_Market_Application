package com.prajwal.ecommerce.record;

import com.prajwal.ecommerce.model.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
