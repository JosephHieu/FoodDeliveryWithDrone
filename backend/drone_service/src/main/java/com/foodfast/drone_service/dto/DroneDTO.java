package com.foodfast.drone_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object representing a drone entity used for delivery operations.
 *
 * <p>This DTO is commonly used when transferring drone data between
 * services or clients, supporting scenarios such as drone registration,
 * dashboard listing, operational monitoring, and real-time tracking.</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneDTO {

    /**
     * Unique identifier of the drone.
     */
    private String id;

    /**
     * ID of the restaurant that owns or manages the drone.
     */
    private String restaurantId;

    /**
     * Display name of the restaurant associated with the drone.
     */
    private String restaurantName;

    /**
     * Model or type of the drone (e.g., DJI-XR1, AirJet-500).
     */
    private String model;

    /**
     * Maximum payload capacity of the drone (in kilograms).
     */
    private double capacity;

    /**
     * Current battery level of the drone, expressed as a percentage.
     */
    private double battery;

    /**
     * Maximum travel range of the drone (in kilometers).
     */
    private double range;

    /**
     * Operational status of the drone.
     * <p>Example values:
     * 0 = idle,
     * 1 = delivering,
     * 2 = charging,
     * 3 = offline, ...</p>
     */
    private Integer status;

    /**
     * Timestamp indicating when the drone record was created.
     */
    private LocalDateTime createdAt;
}
