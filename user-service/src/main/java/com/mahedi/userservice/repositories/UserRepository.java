package com.mahedi.userservice.repositories;

import com.mahedi.userservice.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);

    @Query(
            value = "SELECT * FROM user WHERE roleid = 2",
            nativeQuery = true)
    Collection<User> findAllUsers();

    @Query(
            value = "SELECT * FROM user WHERE roleid = 1",
            nativeQuery = true)
    Collection<User> findAllAdmins();
}
