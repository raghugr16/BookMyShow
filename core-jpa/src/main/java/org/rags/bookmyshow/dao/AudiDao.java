package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Audi;

import java.util.Optional;
import java.util.UUID;

public interface AudiDao {

    public Optional<Audi> findById(UUID uuid);

}
