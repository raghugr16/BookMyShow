package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, UUID> {
}