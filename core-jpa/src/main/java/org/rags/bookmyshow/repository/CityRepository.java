package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}