package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.MovieScreen;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public interface MovieScreenDao {

    public MovieScreen bookMovieScreen(UUID movieId, UUID theaterId, UUID audiId, Date audiDate, Time audiStartTime, Time audiEndTime);

    public boolean createMovieScreenTable(MovieScreen movieScreen);
}

