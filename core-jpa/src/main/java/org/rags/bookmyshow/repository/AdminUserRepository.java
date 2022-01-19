package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminUserRepository extends JpaRepository<AdminUser, UUID> {
}