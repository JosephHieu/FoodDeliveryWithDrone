package com.foodfast.payment_service.repository;

import com.foodfast.payment_service.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing {@link Payment} documents in MongoDB.
 *
 * <p>This interface extends {@link MongoRepository}, providing built-in CRUD
 * operations. Custom query methods are added to support validation and lookup
 * operations related to payment records.</p>
 */
public interface PaymentRepository extends MongoRepository<Payment, String> {

    /**
     * Checks whether a payment record exists with the specified transaction ID.
     *
     * <p>Useful for preventing duplicate payments, validating callbacks from
     * third-party payment gateways, or ensuring transaction uniqueness.</p>
     *
     * @param transactionId the unique transaction identifier
     * @return true if a payment with the given transaction ID exists, otherwise false
     */
    boolean existsByTransactionId(String transactionId);
}
