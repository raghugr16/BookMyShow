package org.rags.bookmyshow.repository;

import org.rags.bookmyshow.entity.BookMyShowApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookMyShowAppRepository extends JpaRepository<BookMyShowApp, UUID> {
}