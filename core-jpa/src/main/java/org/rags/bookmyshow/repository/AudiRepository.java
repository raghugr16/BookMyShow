package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.Audi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AudiRepository extends JpaRepository<Audi, UUID> {
}
