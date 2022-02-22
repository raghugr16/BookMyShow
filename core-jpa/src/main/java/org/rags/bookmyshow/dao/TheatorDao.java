package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Theater;

import java.util.Optional;
import java.util.UUID;

public interface TheatorDao {

    Optional<Theater> findById(UUID uuid);

}
