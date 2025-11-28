package com.foodfast.cart_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.foodfast.cart_service.model.Cart;

/**
 * Repository interface for performing CRUD and custom query operations
 * on {@link Cart} documents in MongoDB.
 *
 * <p>This interface extends {@link MongoRepository}, which provides
 * built-in CRUD functionality. Additional query methods are declared
 * to support cart-specific operations.</p>
 */
@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    /**
     * Retrieves a user's cart based on their user ID.
     *
     * <p>This method is typically used to fetch the active cart associated
     * with a user for checkout, item management, or cart preview operations.</p>
     *
     * @param userId the ID of the user
     * @return an {@link Optional} containing the user's cart if found,
     *         or an empty Optional otherwise
     */
    Optional<Cart> findByUserId(String userId);
}
