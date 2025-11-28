package com.foodfast.restaurant_service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.foodfast.restaurant_service.model.Restaurant;

/**
 * Repository interface for performing CRUD and custom query operations
 * on {@link Restaurant} documents in MongoDB.
 *
 * <p>This interface extends {@link MongoRepository}, providing built-in
 * CRUD functionality. Additional derived query methods are declared to
 * support filtering, searching, and validation logic for restaurants.</p>
 */
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

    /**
     * Searches restaurants by name (case-insensitive) and status, returning paginated results.
     *
     * @param name     keyword to search within the restaurant name
     * @param status   restaurant status value (e.g. 1 = active, 0 = inactive)
     * @param pageable pagination configuration
     * @return a page of restaurants matching both name and status filters
     */
    Page<Restaurant> findByNameContainingIgnoreCaseAndStatus(String name, Integer status, Pageable pageable);

    /**
     * Searches restaurants by name (case-insensitive), returning paginated results.
     *
     * @param name     keyword to search within the restaurant name
     * @param pageable pagination configuration
     * @return a page of restaurants whose names contain the specified text
     */
    Page<Restaurant> findByNameContainingIgnoreCase(String name, Pageable pageable);

    /**
     * Retrieves a list of restaurants filtered by their status.
     *
     * @param status restaurant status value
     * @return list of restaurants with the specified status
     */
    List<Restaurant> findByStatus(int status);

    /**
     * Checks whether a restaurant already exists with the given name.
     *
     * @param name restaurant name to verify
     * @return true if a restaurant with the given name exists, otherwise false
     */
    boolean existsByName(String name);

    /**
     * Checks if a restaurant exists at the specified latitude and longitude.
     *
     * @param latitude  latitude coordinate
     * @param longitude longitude coordinate
     * @return true if a restaurant exists at this exact location, otherwise false
     */
    boolean existsByLocation_LatitudeAndLocation_Longitude(double latitude, double longitude);

    /**
     * Checks if another restaurant exists with the same name,
     * excluding a specific restaurant ID. Useful for update validation.
     *
     * @param name restaurant name
     * @param id   ID of the restaurant to exclude
     * @return true if another restaurant with the same name exists, otherwise false
     */
    boolean existsByNameAndIdNot(String name, String id);

    /**
     * Checks if another restaurant exists at the same location,
     * excluding a specific restaurant ID. Useful for update validation.
     *
     * @param latitude  latitude coordinate
     * @param longitude longitude coordinate
     * @param id        ID of the restaurant to exclude
     * @return true if another restaurant at that location exists, otherwise false
     */
    boolean existsByLocation_LatitudeAndLocation_LongitudeAndIdNot(
            double latitude,
            double longitude,
            String id
    );

    /**
     * Retrieves a paginated list of restaurants owned by a specific user,
     * filtered by name keyword (case-insensitive).
     *
     * @param ownerId   ID of the restaurant owner
     * @param name      name keyword to filter
     * @param pageable  pagination configuration
     * @return a page of restaurants owned by the given user and matching the name filter
     */
    Page<Restaurant> findByOwnerIdAndNameContainingIgnoreCase(
            String ownerId,
            String name,
            Pageable pageable
    );

    /**
     * Retrieves a paginated list of restaurants owned by a specific user.
     *
     * @param ownerId  ID of the restaurant owner
     * @param pageable pagination configuration
     * @return a page of restaurants owned by the specified user
     */
    Page<Restaurant> findByOwnerId(String ownerId, Pageable pageable);

    /**
     * Retrieves all restaurants owned by a specific user.
     *
     * @param ownerId ID of the restaurant owner
     * @return list of restaurants belonging to the specified owner
     */
    List<Restaurant> findByOwnerId(String ownerId);
}
