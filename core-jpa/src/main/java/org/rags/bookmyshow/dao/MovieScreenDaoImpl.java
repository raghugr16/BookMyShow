package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieScreenDaoImpl implements MovieScreenDao {

    @Autowired
    MovieDao movieDaoImpl;

    @Autowired
    TheatorDaoImpl theatorDaoImpl;

    @Autowired
    DataSource dataSource;

    @Override
    public MovieScreen bookMovieScreen(UUID movieId, UUID theaterId, UUID audiId, Date audiDate, Time audiStartTime, Time audiEndTime) {
        Optional<Movie> movie = movieDaoImpl.findById(movieId);
        Optional<Theater> theater = theatorDaoImpl.findById(theaterId);
        MovieScreen movieScreen = null;

        if(movie.isPresent()){
            if(theater.isPresent()){
                Collection<Audi> audiList = theater.get().getAudiList();
                Optional<Audi> audiOptional = audiList.stream().filter(audi -> audi.getAudiId().equals(audiId))
                        .findFirst();
                if(audiOptional.isPresent()){
                    Audi audi = audiOptional.get();
                    String movieScreenTableName = generateMovieScreenTableName(theater.get(), audi.getAudiId(), movie.get(), audiStartTime);
                    String movieShortName = "Show" + UUID.randomUUID();
                    movieScreen =  MovieScreen.builder()
                                                .audi(audi)
                                                .isActive(true)
                                                .audiDate(audiDate)
                                                .audiStartTime(audiStartTime)
                                                .audiEndTime((audiEndTime))
                                                .movieScreenTable(movieScreenTableName)
                                                .movieScreenShortName(movieShortName)
                                                .screenStatus(ScreenStatus.SCHEDULED)
                                                .build();

                }
            }
        }
        return movieScreen;
    }

    @Override
    public boolean createMovieScreenTable(MovieScreen movieScreen) {
        String tableName = movieScreen.getMovieScreenShortName();
        Audi audi = movieScreen.getAudi();
        Integer noOfSeats = audi.getNo_of_seats();


        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.execute("create table "+ tableName + "(id int,name varchar2(20)");

        for(int i=1; i < noOfSeats; i++){
            jt.execute("insert into "+ tableName + "(id, name) values (1, 'A')\")");
        }
        return true;
    }

    public String generateMovieScreenTableName(Theater theater, UUID audiId, Movie movie, Time audiStartTime) {
        StringBuffer movieScreenDate = new StringBuffer();
        String bookMyShowAppId = theater.getBookMyShowApp().getBookMyShowAppId().toString();
        String cityId = theater.getCity().getCityId().toString();
        String theaterId = theater.getTheaterId().toString();
        String audiIdString = audiId.toString();
        String movieId = movie.getMovieId().toString();

        movieScreenDate.append("show")
                .append(bookMyShowAppId)
                .append(cityId)
                .append(theaterId)
                .append(audiIdString)
                .append(movieId)
                .append(audiStartTime.toString());

        return movieScreenDate.toString();
    }

}
