package com.mahedi.userservice.repositories;

import com.mahedi.userservice.data.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
