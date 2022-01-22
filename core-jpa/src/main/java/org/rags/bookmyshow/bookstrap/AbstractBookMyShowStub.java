package org.rags.bookmyshow.bookstrap;

import org.rags.bookmyshow.entity.*;

import java.sql.Timestamp;

public abstract class AbstractBookMyShowStub {



    public AdminUser createInitAdminUser(String password, String username, String email){
        AdminUser adminUser = AdminUser.builder()
                .password(password)
                .userName(username)
                .isActive(true)
                .email(email)
                .userName(username)
                .lastModified(new Timestamp(System.currentTimeMillis()))
                .build();
        return adminUser;
    }

    public Audi createInitAudi(String audiName, AudiSize audiSize, AudiType audiType, int no_of_seat){
        Audi audi = Audi.builder()
                .audiName(audiName)
                .audiSize(audiSize)
                .audiType(audiType)
                .no_of_seats(no_of_seat)
                .isActive(true)
                .build();
        return audi;
    }

    public BookMyShowApp createInitBookMyShowApp(){
        BookMyShowApp bookMyShowApp = BookMyShowApp.builder()
                .isActive(true)
                .build();
        return bookMyShowApp;
    }

    public Address createAddress(String street, String cityName, String pincode, String country){
        Address address = Address.builder()
                .cityName(cityName)
                .state(street)
                .pincode(pincode)
                .country(country)
                .build();
        return address;
    }
    public City createInitCity(){
        City city = City.builder()
                        .isActive(true)
                        .build();
        return city;
    }

    public CustomerUser createInitCustomerUser(String customerUsername, String customerUserEmail,String customerUserpassword){
        CustomerUser customerUser = CustomerUser.builder()
                                                .userName(customerUsername)
                                                .email(customerUserEmail)
                                                .password(customerUserpassword)
                                                .isActive(true)
                                                .build();
        return customerUser;
    }
    public Movie createInitMovie(String movieName, MovieGenres movieGenres){
        Movie movie = Movie.builder()
                        .movieName(movieName)
                        .movieGenres(movieGenres)
                        .isActive(true)
                        .build();
        return movie;
    }


    public Theater createInitTheater(String theaterName, TheaterType theaterType){
        Theater theater = Theater.builder()
                                .theaterName(theaterName)
                                .theaterType(theaterType)
                                .isActive(true)
                                .build();
        return theater;
    }

    public Theater createInitSingleTheater(String theaterName, TheaterType theaterType){
        Theater theater = Theater.builder()
                .theaterType(theaterType)
                .theaterName(theaterName)
                .isActive(true)
                .build();
        return theater;
    }

    public TheaterUser createInitTheaterUser(String theaterUsername, String theaterUserEmail,String theaterUserpassword){
        TheaterUser theaterUser = TheaterUser.builder()
                        .userName(theaterUsername)
                        .email(theaterUserEmail)
                        .password(theaterUserpassword)
                        .build();
        return theaterUser;
    }
}
