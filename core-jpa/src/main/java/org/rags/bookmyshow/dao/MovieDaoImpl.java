package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.Movie;
import org.rags.bookmyshow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MovieDaoImpl implements MovieDao {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(UUID movieId) {
        return movieRepository.findById(movieId);
    }


}
