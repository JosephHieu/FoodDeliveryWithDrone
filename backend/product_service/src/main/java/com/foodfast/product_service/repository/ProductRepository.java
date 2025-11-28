package com.foodfast.product_service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.foodfast.product_service.model.Product;

/**
 * Repository interface for performing CRUD and custom query operations
 * on {@link Product} documents.
 *
 * <p>This interface extends {@link MongoRepository}, offering built-in
 * CRUD functionality. Additional methods are provided to support
 * filtering, searching, and validation logic specific to product data.</p>
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    /**
     * Searches products by name (case-insensitive), returning paginated results.
     *
     * @param q         keyword to search within the product name
     * @param pageable  pagination configuration
     * @return a page of products matching the name keyword
     */
    Page<Product> findByNameContainingIgnoreCase(String q, Pageable pageable);

    /**
     * Checks if a product exists with the given name.
     *
     * @param name the product name to check
     * @return true if a product with the given name exists, otherwise false
     */
    boolean existsByName(String name);

    /**
     * Retrieves all products belonging to a specific restaurant.
     *
     * @param restaurantId ID of the restaurant
     * @return list of products associated with the given restaurant
     */
    List<Product> findByRestaurantId(String restaurantId);

    /**
     * Retrieves products filtered by status, returned as paginated results.
     *
     * @param status    product status (e.g., 1 = active, 0 = inactive)
     * @param pageable  pagination configuration
     * @return a page of products with the specified status
     */
    Page<Product> findByStatus(Integer status, Pageable pageable);

    /**
     * Retrieves products belonging to a set of restaurants, returned as paginated results.
     *
     * @param restaurantIds list of restaurant IDs
     * @param pageable      pagination configuration
     * @return a page of products that belong to the specified restaurants
     */
    Page<Product> findByRestaurantIdIn(List<String> restaurantIds, Pageable pageable);

    /**
     * Retrieves products belonging to multiple restaurants and filtered by
     * name keyword (case-insensitive), returned as paginated results.
     *
     * @param restaurantIds list of restaurant IDs
     * @param name          keyword to search within the product name
     * @param pageable      pagination configuration
     * @return a page of products matching both restaurant and name filters
     */
    Page<Product> findByRestaurantIdInAndNameContainingIgnoreCase(
            List<String> restaurantIds,
            String name,
            Pageable pageable
    );

    /**
     * Searches products by both status and name keyword (case-insensitive),
     * returned as paginated results.
     *
     * @param status    product status
     * @param name      name keyword to filter by
     * @param pageable  pagination configuration
     * @return a page of products filtered by both status and name
     */
    Page<Product> findByStatusAndNameContainingIgnoreCase(
            Integer status,
            String name,
            Pageable pageable
    );
}
