package org.rags.bookmyshow.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.rags.bookmyshow.bookstrap.BaseBookMyShowStub;
import org.rags.bookmyshow.entity.*;
import org.rags.bookmyshow.repository.BookMyShowAppRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Time;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"org.rags.bookmyshow"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieScreenDaoImplTest extends BaseBookMyShowStub {

    private static Logger logger = LoggerFactory.getLogger(MovieScreenDaoImplTest.class.getName());

    @Autowired
    BookMyShowAppRepository bookMyShowAppRepository;

    @Autowired
    MovieScreenDaoImpl movieScreenDaoImpl;

    @Autowired
    MovieDaoImpl movieDaoImpl;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createScreenTableNameTest(){
        BookMyShowApp bookMyShowApp = createBookMyShowApp();
        BookMyShowApp saved = bookMyShowAppRepository.save(bookMyShowApp);
        Assertions.assertThat(saved).isNotNull();
        logger.info("BookMyShowApp Id = " + saved.getBookMyShowAppId().toString());

        //bookMovieScreen(UUID movieId, UUID theaterId, UUID audiId, Date audiDate, Time audiStartTime, Time audiEndTime) {
        //UUID movieId = bookMyShowApp.

        //movieScreenDaoImpl.generateMovieScreenTableName();
        Theater theater = bookMyShowApp.getTheaterList().get(0);

        //UUID audiId, Movie movie, Time audiStartTime
        Audi audi = theater.getAudiList().get(0);

        // Movie
        Movie movie = Movie.builder()
                .movieId(UUID.randomUUID())
                .movieGenres(MovieGenres.ACTION)
                .movieName("Ben_Hur")
                .build();

        Date audiDate = new Date();
        Date startTime = addHoursToJavaUtilDate(new Date(),3,3,45);
        Date endTime = addHoursToJavaUtilDate(startTime,3,3,45);

        MovieScreen movieScreen = MovieScreen.builder()
                .movieScreenTimeId(UUID.randomUUID())
                .audiDate(audiDate)
                .audiStartTime(new Time(startTime.getTime()))
                .audiEndTime(new Time(endTime.getTime()))
                .movie(movie)
                .audi(audi)
                .screenStatus(ScreenStatus.SCHEDULED)
                .build();

        List<MovieScreen> movieScreenList = new ArrayList<>();
        movieScreenList.add(movieScreen);

        movie.setMovieScreenTimes(movieScreenList);

        movieDaoImpl.save(movie);

        String tableName = movieScreenDaoImpl.generateMovieScreenTableName(theater,audi.getAudiId(),movie,new Time(startTime.getTime()));
        System.out.println("Table Name "+ tableName);
        Assertions.assertThat(tableName).isNotNull();



    }

    public Date addHoursToJavaUtilDate(Date date, int hours, int minute, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        calendar.add(Calendar.MINUTE, minute);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

}
