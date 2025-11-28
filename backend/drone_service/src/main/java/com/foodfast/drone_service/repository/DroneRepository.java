package com.foodfast.drone_service.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.foodfast.drone_service.model.Drone;

/**
 * Repository interface for performing CRUD operations and custom queries
 * on the {@link Drone} collection.
 *
 * <p>This interface extends {@link MongoRepository}, which provides
 * built-in methods such as save(), findAll(), deleteById(), etc.
 *
 * <p>Additional query methods are defined using Spring Data's derived
 * query mechanism.
 */
@Repository
public interface DroneRepository extends MongoRepository<Drone, String> {

    /**
     * Searches drones by model name, ignoring case sensitivity,
     * and returns paginated results.
     *
     * @param model search keyword for drone model
     * @param pageable pagination configuration
     * @return a page of drones matching the model search
     */
    Page<Drone> findByModelContainingIgnoreCase(String model, Pageable pageable);

    /**
     * Retrieves all drones with a given status.
     *
     * @param status numeric drone status (e.g. 0 = inactive, 1 = active, etc.)
     * @return list of drones with the specified status
     */
    List<Drone> findByStatus(int status);

    /**
     * Retrieves all drones belonging to a specific restaurant
     * and filtered by status.
     *
     * @param restaurantId the ID of the restaurant
     * @param status drone status filter
     * @return list of drones that match both restaurant and status
     */
    List<Drone> findByRestaurantIdAndStatus(String restaurantId, Integer status);

    /**
     * Retrieves drones associated with multiple restaurants,
     * returned as paginated results.
     *
     * @param restaurantIds list of restaurant IDs
     * @param pageable pagination configuration
     * @return a page of drones belonging to any of the specified restaurants
     */
    Page<Drone> findByRestaurantIdIn(List<String> restaurantIds, Pageable pageable);

    /**
     * Retrieves drones belonging to any of the specified restaurants
     * and filtered by model keyword (case-insensitive),
     * returned as paginated results.
     *
     * @param restaurantIds list of restaurant IDs
     * @param model model name filter (case-insensitive)
     * @param pageable pagination configuration
     * @return a page of drones matching restaurant and model filters
     */
    Page<Drone> findByRestaurantIdInAndModelContainingIgnoreCase(
            List<String> restaurantIds,
            String model,
            Pageable pageable
    );
}
