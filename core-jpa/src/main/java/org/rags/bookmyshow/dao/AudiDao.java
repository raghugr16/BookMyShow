package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Audi;
import org.rags.bookmyshow.entity.Seat;
import org.rags.bookmyshow.exception.AudiNotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface AudiDao {

    public Optional<Audi> findById(UUID uuid);

    public void addSeat(UUID auidId, Seat seat) throws AudiNotFoundException;

    public void save(Audi audi);

}
