package com.prajwal.ecommerce.record;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
