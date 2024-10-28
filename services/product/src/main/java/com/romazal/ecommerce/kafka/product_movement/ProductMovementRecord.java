package com.romazal.ecommerce.kafka.product_movement;

import java.util.UUID;

public record ProductMovementRecord(
        UUID productId,
        Double movementQuantity,
        Double stockQuantityBefore,
        Double stockQuantityAfter,
        MovementType movementType
) {
}
