package com.mahedi.userservice.repositories;

import com.mahedi.userservice.data.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

public interface UserRepository extends CrudRepository<User, Integer> {
}
