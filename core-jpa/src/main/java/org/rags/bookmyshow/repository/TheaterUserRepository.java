package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.TheaterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheaterUserRepository extends JpaRepository<TheaterUser, UUID> {
}