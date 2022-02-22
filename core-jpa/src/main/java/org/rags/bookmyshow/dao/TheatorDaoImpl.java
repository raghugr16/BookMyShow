package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Theater;
import org.rags.bookmyshow.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TheatorDaoImpl implements TheatorDao {

    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public Optional<Theater> findById(UUID uuid) {
        Optional<Theater>  theater = theaterRepository.findById(uuid);
        return theater;
    }
}
