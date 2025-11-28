package com.foodfast.drone_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing a delivery assignment handled by a drone.
 *
 * <p>This DTO carries essential delivery-related information across services,
 * including the drone assigned, the related order, restaurant metadata, and
 * the current tracking location. It is mainly used for delivery tracking,
 * mapping visualization, and status updates in the drone service.</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {

    /**
     * Unique identifier of the delivery record.
     */
    private String id;

    /**
     * ID of the order associated with this delivery.
     */
    private String orderId;

    /**
     * ID of the drone assigned to handle the delivery.
     */
    private String droneId;

    /**
     * ID of the restaurant preparing the order.
     */
    private String restaurantId;

    /**
     * Name of the restaurant.
     */
    private String restaurantName;

    /**
     * Geographic location of the restaurant where the delivery begins.
     */
    private LocationDTO restaurantLocation;

    /**
     * Current geographic location of the drone during the delivery.
     * Useful for real-time delivery tracking.
     */
    private LocationDTO currentLocation;

    /**
     * Timestamp indicating when the delivery record was created.
     */
    private LocalDateTime createdAt;
}
