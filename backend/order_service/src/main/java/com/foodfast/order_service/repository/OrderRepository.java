package com.foodfast.order_service.repository;

import com.foodfast.order_service.model.Order;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing {@link Order} documents in MongoDB.
 *
 * <p>Extends {@link MongoRepository} to provide CRUD operations. Additional
 * derived query methods are declared to support filtering orders by user,
 * status, product references, timestamps, and order metadata.</p>
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    /**
     * Retrieves a paginated list of all orders.
     *
     * @param pageable pagination configuration
     * @return a page containing orders
     */
    Page<Order> findAll(Pageable pageable);

    /**
     * Retrieves orders for a specific user, excluding orders with the given status.
     *
     * <p>This is commonly used to filter out cancelled or deleted orders
     * from the user's order history.</p>
     *
     * @param userId the ID of the user
     * @param status the status to exclude
     * @param pageable pagination configuration
     * @return a page of orders matching the criteria
     */
    Page<Order> findByUserIdAndStatusNot(String userId, Integer status, Pageable pageable);

    /**
     * Searches orders by order code (case-insensitive), returning paginated results.
     *
     * @param orderCode keyword to search in the order code
     * @param pageable  pagination configuration
     * @return a page of orders whose codes contain the given text
     */
    Page<Order> findByOrderCodeContainingIgnoreCase(String orderCode, Pageable pageable);

    /**
     * Retrieves orders containing products that match the provided product IDs.
     *
     * @param productIds list of product IDs to filter by
     * @param pageable   pagination configuration
     * @return a page of orders containing any of the specified products
     */
    Page<Order> findByItemsProductIdIn(List<String> productIds, Pageable pageable);

    /**
     * Checks whether an order already exists with the given order code.
     *
     * @param orderCode the order code to validate
     * @return true if the order code exists, otherwise false
     */
    boolean existsByOrderCode(String orderCode);

    /**
     * Finds an order by its unique order code.
     *
     * @param orderCode the order code to search for
     * @return an optional containing the order if found, otherwise empty
     */
    Optional<Order> findByOrderCode(String orderCode);

    /**
     * Retrieves a page of orders filtered by product IDs and order code (case-insensitive).
     *
     * @param productIds list of product IDs to search within order items
     * @param orderCode  keyword to filter order codes
     * @param pageable   pagination configuration
     * @return a page of orders matching both product and order code filters
     */
    Page<Order> findByItemsProductIdInAndOrderCodeContainingIgnoreCase(
            List<String> productIds,
            String orderCode,
            Pageable pageable
    );

    /**
     * Retrieves orders with a given status that were created before a specified timestamp.
     *
     * <p>Useful for scheduled cleanup jobs, auto-cancellations,
     * and batch processing of outdated or expired orders.</p>
     *
     * @param status     the status to filter by
     * @param createdAt  the timestamp threshold
     * @return a list of orders matching the status and time condition
     */
    List<Order> findByStatusAndCreatedAtBefore(Integer status, Instant createdAt);
}
