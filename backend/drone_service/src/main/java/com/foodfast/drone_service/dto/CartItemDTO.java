package com.foodfast.drone_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing an individual item inside a user's cart.
 *
 * <p>This DTO contains product-level information used for pricing,
 * quantity tracking, order calculation, and delivery preparation
 * within the drone service.</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    /**
     * Unique identifier of the product.
     */
    private String productId;

    /**
     * Display name of the product.
     */
    private String name;

    /**
     * URL of the product image.
     */
    private String image;

    /**
     * Unit price of the product.
     */
    private BigDecimal price;

    /**
     * Quantity of this product in the cart.
     */
    private Integer quantity;
}
