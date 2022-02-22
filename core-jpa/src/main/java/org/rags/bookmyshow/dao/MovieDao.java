package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Movie;

import java.util.Optional;
import java.util.UUID;

public interface MovieDao {

    public Movie save(Movie movie);

    public Optional<Movie> findById(UUID movieId);
}
