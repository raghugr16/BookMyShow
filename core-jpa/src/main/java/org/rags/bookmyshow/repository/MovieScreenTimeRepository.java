package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.MovieScreen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieScreenTimeRepository extends JpaRepository<MovieScreen, UUID> {
}