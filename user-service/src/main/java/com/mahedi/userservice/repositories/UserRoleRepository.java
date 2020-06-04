package com.mahedi.userservice.repositories;

import com.mahedi.userservice.data.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
}
