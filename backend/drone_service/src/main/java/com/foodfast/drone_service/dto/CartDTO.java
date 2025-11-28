package com.foodfast.drone_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object representing a user's shopping cart.
 *
 * <p>This DTO is typically used when retrieving or transmitting cart
 * information between services, such as during checkout operations or
 * when calculating delivery requirements for the drone service.</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /**
     * Unique identifier of the cart.
     */
    private String id;

    /**
     * ID of the user who owns the cart.
     */
    private String userId;

    /**
     * List of items contained in the user's cart.
     */
    private List<CartItemDTO> items;
}
