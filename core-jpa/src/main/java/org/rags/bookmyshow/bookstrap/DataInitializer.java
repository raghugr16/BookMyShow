package org.rags.bookmyshow.bookstrap;

import org.rags.bookmyshow.dao.BookMyShowAppDaoImpl;
import org.rags.bookmyshow.entity.AdminUser;
import org.rags.bookmyshow.entity.BookMyShowApp;
import org.rags.bookmyshow.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jt on 6/12/21.
 */
@Profile({"dev"})
@Component
public class DataInitializer extends BaseBookMyShowStub implements CommandLineRunner{

    private final AdminUserRepository adminUserRepository;
    private final AudiRepository audiRepository;
    private final BookMyShowAppRepository bookMyShowAppRepository;
    private final CityRepository cityRepository;
    private final CustomerUserRepository customerUserRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final TheaterUserRepository theaterUserRepository;
    private final BookMyShowAppDaoImpl bookMyShowAppDao;

    public DataInitializer(AdminUserRepository adminUserRepository, AudiRepository audiRepository, BookMyShowAppRepository bookMyShowAppRepository, CityRepository cityRepository, CustomerUserRepository customerUserRepository, MovieRepository movieRepository, TheaterRepository theaterRepository, TheaterUserRepository theaterUserRepository, BookMyShowAppDaoImpl bookMyShowAppDao) {
        this.adminUserRepository = adminUserRepository;
        this.audiRepository = audiRepository;
        this.bookMyShowAppRepository = bookMyShowAppRepository;
        this.cityRepository = cityRepository;
        this.customerUserRepository = customerUserRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.theaterUserRepository = theaterUserRepository;
        this.bookMyShowAppDao = bookMyShowAppDao;
    }

    @Override
    public void run(String... args) {
        this.deleteAll();
        BookMyShowApp bookMyShowApp = createBookMyShowApp();
        BookMyShowApp saved = bookMyShowAppDao.save(bookMyShowApp);
        System.out.println("bookMyshow " + saved.getBookMyShowAppId());
        List<AdminUser> adminUsers = saved.getAdminUsers();
        printAllAdminUsers(adminUsers);
    }

    public void printAllAdminUsers(List<AdminUser> adminUsers){
        for(AdminUser adminUser: adminUsers){
            System.out.println("Admin User = " + adminUser.getAdminId());
        }
    }

    public void deleteAll(){
        this.adminUserRepository.deleteAll();
        this.movieRepository.deleteAll();
        this.audiRepository.deleteAll();
        this.bookMyShowAppRepository.deleteAll();
        this.cityRepository.deleteAll();
        this.customerUserRepository.deleteAll();
        this.movieRepository.deleteAll();
        this.theaterRepository.deleteAll();
        this.theaterUserRepository.deleteAll();
    }
}
