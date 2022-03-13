package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Audi;
import org.rags.bookmyshow.entity.Seat;
import org.rags.bookmyshow.exception.AudiNotFoundException;
import org.rags.bookmyshow.repository.AudiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AudiDaoImpl implements AudiDao{

    Logger logger = LoggerFactory.getLogger(AudiDaoImpl.class);

    @Autowired
    AudiRepository audiRepository;

    @Override
    public Optional<Audi> findById(UUID uuid) {
        Optional<Audi> audi = audiRepository.findById(uuid);
        return audi;
    }

    @Override
    public void addSeat(UUID audiId, Seat seat) throws AudiNotFoundException {
        Optional<Audi> audiOptional = audiRepository.findById(audiId);
        if(audiOptional.isPresent()){
            Audi audi = audiOptional.get();
            List<Seat> seatList = audi.getSeatList();
            seatList.add(seat);
            audi.setSeatList(seatList);
            audiRepository.save(audi);
        }
    }

    @Override
    public void save(Audi audi) {
        audiRepository.save(audi);
    }
}
