package com.foodfast.user_service.repository;

import java.util.List;
import java.util.Optional;

import com.foodfast.user_service.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for accessing and manipulating {@link User} entities.
 *
 * <p>This interface extends {@link MongoRepository}, which provides
 * basic CRUD operations. Additional query methods are defined using
 * Spring Data's derived query mechanism.</p>
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Retrieves all users with a specific role and orders them by creation time
     * in descending order (newest first).
     *
     * @param role the user role (e.g., 0 = customer, 1 = admin, etc.)
     * @return a list of users sorted by creation date descending
     */
    List<User> findAllByRoleOrderByCreatedAtDesc(Integer role);

    /**
     * Searches users by role, name keyword (case-insensitive), and status,
     * returning paginated results.
     *
     * @param role     user role to filter by
     * @param fullname keyword to search in the user's full name
     * @param status   account status (e.g., 1 = active, 0 = inactive)
     * @param pageable pagination configuration
     * @return a page of users that match all filter conditions
     */
    Page<User> findByRoleAndFullnameContainingIgnoreCaseAndStatus(
            Integer role,
            String fullname,
            Integer status,
            Pageable pageable
    );

    /**
     * Searches users by role and name keyword (case-insensitive),
     * returning paginated results.
     *
     * @param role     user role to filter by
     * @param fullname keyword to search in the user's full name
     * @param pageable pagination configuration
     * @return a page of users matching the role and name filters
     */
    Page<User> findByRoleAndFullnameContainingIgnoreCase(
            Integer role,
            String fullname,
            Pageable pageable
    );

    /**
     * Checks whether a user already exists with the given email.
     *
     * @param email the email to check
     * @return true if a user with the given email exists, otherwise false
     */
    boolean existsByEmail(String email);

    /**
     * Checks whether a user already exists with the given phone number.
     *
     * @param phone the phone number to check
     * @return true if a user with the given phone exists, otherwise false
     */
    boolean existsByPhone(String phone);

    /**
     * Finds a user by their email address.
     *
     * @param email the email to search for
     * @return an {@link Optional} containing the found user, or empty if not found
     */
    Optional<User> findByEmail(String email);
}
