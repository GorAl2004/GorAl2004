package com.test.repository;

import com.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
/*@Transactional(readOnly = true)*/
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE  u.email = ?1")
    User findByEmail(String email);

    User getByName(String name);

    User getByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE u.reset_password_token = ?1")
    User getByReset_password_token(String reset_password_token);
}
