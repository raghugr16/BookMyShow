package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Audi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class AudiDaoImpl implements AudiDao{

    @Autowired
    AudiDao audiDaoImpl;

    @Override
    public Optional<Audi> findById(UUID uuid) {
        Optional<Audi> audi = audiDaoImpl.findById(uuid);
        return audi;
    }
}
