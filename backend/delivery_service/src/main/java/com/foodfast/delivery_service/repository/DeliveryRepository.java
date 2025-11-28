package com.foodfast.delivery_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.foodfast.delivery_service.model.Delivery;

/**
 * Repository interface for managing {@link Delivery} documents in MongoDB.
 *
 * <p>This interface extends {@link MongoRepository}, which provides built-in
 * CRUD operations. Custom query methods are added to support delivery
 * retrieval based on order-specific conditions.</p>
 */
@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {

    /**
     * Retrieves all delivery records associated with a specific order ID.
     *
     * <p>This method is typically used for scenarios where an order may have
     * multiple delivery attempts or delivery history logs.</p>
     *
     * @param orderId the ID of the order
     * @return a list of delivery records related to the given order ID
     */
    List<Delivery> findAllByOrderId(String orderId);
}
