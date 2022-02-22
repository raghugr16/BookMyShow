package org.rags.bookmyshow.bookstrap;

import org.rags.bookmyshow.entity.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseBookMyShowStub extends AbstractBookMyShowStub {

    public AdminUser createAdminUser(String password, String username, String email){
        AdminUser adminUser = createInitAdminUser(password,username,email);


        return null;
    }

    public BookMyShowApp createBookMyShowApp(){
        BookMyShowApp bookMyShowApp = createInitBookMyShowApp();

        bookMyShowApp.setTheaterList(createCollectionOfTheater(bookMyShowApp));
        bookMyShowApp.setTheaterUsers(createCollectionOfTheaterUser(bookMyShowApp));
        bookMyShowApp.setCustomerUsers(createCollectionOfCustomerUser(bookMyShowApp));
        bookMyShowApp.setAdminUsers(createCollectionOfAdminUser(bookMyShowApp));

        return bookMyShowApp;
    }

    public List<AdminUser> createCollectionOfAdminUser(BookMyShowApp bookMyShowApp){
        List<AdminUser> adminUsers = new ArrayList<>();

        AdminUser admin = createInitAdminUser("password","admin","admin@bookmyshow.com");
        admin.setBookMyShowApp(bookMyShowApp);
        adminUsers.add(admin);
        return adminUsers;
    }

    public Collection<CustomerUser> createCollectionOfCustomerUser(BookMyShowApp bookMyShowApp){
        Collection<CustomerUser> customerUsers = new ArrayList<>();

        CustomerUser raghu = createInitCustomerUser("raghu","raghu@gmail.com","password");
        raghu.setBookMyShowApp(bookMyShowApp);

        CustomerUser vinay = createInitCustomerUser("vinay","vinay@gmail.com","password");
        vinay.setBookMyShowApp(bookMyShowApp);

        customerUsers.add(raghu);
        customerUsers.add(vinay);
        return customerUsers;
    }

    public Collection<TheaterUser> createCollectionOfTheaterUser(BookMyShowApp bookMyShowApp){
        List<TheaterUser> theaterUserList = new ArrayList<>();
        TheaterUser banglore_multiplex = createInitTheaterUser("banglore_multiplex","banglore_multiplex@gmail.com", "password");
        banglore_multiplex.setBookMyShowApp(bookMyShowApp);

        TheaterUser vinayaka = createInitTheaterUser("vinayaka", "vinayaka@gmail.com", "password");
        vinayaka.setBookMyShowApp(bookMyShowApp);

        theaterUserList.add(banglore_multiplex);
        theaterUserList.add(vinayaka);

        return theaterUserList;
    }

    public List<Theater> createCollectionOfTheater(BookMyShowApp bookMyShowApp){
        List<Theater> theaterList = new ArrayList<>();

        City banglore = createInitCity();
        banglore.setAddress(createBangloreAddress());

        City mysore = createInitCity();
        banglore.setAddress(createMysoreAddress());

        List<Audi> audiList = createBangloreMultiplexAudi();

        Theater bangloreMultiplexTheater = createMultiplexTheater();
        bangloreMultiplexTheater.setCity(banglore);
        bangloreMultiplexTheater.setAudiList(audiList);
        bangloreMultiplexTheater.setBookMyShowApp(bookMyShowApp);

        Theater vinayakaTheater = createSingleTheater();
        vinayakaTheater.setCity(banglore);
        vinayakaTheater.setAudiList(createVinayakAudi());
        vinayakaTheater.setBookMyShowApp(bookMyShowApp);

        Theater mysoreMiniTheater = createMiniTheater();
        mysoreMiniTheater.setCity(mysore);
        mysoreMiniTheater.setAudiList(createMysoreMiniAudi());
        mysoreMiniTheater.setBookMyShowApp(bookMyShowApp);

        theaterList.add(bangloreMultiplexTheater);
        theaterList.add(vinayakaTheater);
        theaterList.add(mysoreMiniTheater);

        return theaterList;
    }

    public List<Audi> createVinayakAudi(){
        List<Audi> audiList = new ArrayList<>();
        Audi vinayaka = createInitAudi("vinayaka", AudiSize.MIN,AudiType.IMAX, 300);
        audiList.add(vinayaka);
        return audiList;
    }

    public List<Audi> createMysoreMiniAudi(){
        List<Audi> audiList = new ArrayList<>();
        Audi mysore_mini_audi1 = createInitAudi("mysore_mini_audi1", AudiSize.MIN,AudiType.IMAX, 50);
        Audi mysore_mini_audi2 = createInitAudi("mysore_mini_audi2", AudiSize.MIN,AudiType.IMAX, 50);
        Audi mysore_mini_audi3 = createInitAudi("mysore_mini_audi3", AudiSize.MIN,AudiType.IMAX, 50);
        Audi mysore_mini_audi4 = createInitAudi("mysore_mini_audi4", AudiSize.MIN,AudiType.IMAX, 50);

        audiList.add(mysore_mini_audi1);
        audiList.add(mysore_mini_audi2);
        audiList.add(mysore_mini_audi3);
        audiList.add(mysore_mini_audi4);

        return audiList;
    }

    public List<Audi> createBangloreMultiplexAudi(){
        List<Audi> audiList = new ArrayList<>();
        Audi banglore_multiplex_audi1 = createInitAudi("banglore_multiplex_audi1", AudiSize.MIN,AudiType.IMAX, 50);
        Audi banglore_multiplex_audi2 = createInitAudi("banglore_multiplex_audi2", AudiSize.MIN,AudiType.IMAX, 50);
        Audi banglore_multiplex_audi3 = createInitAudi("banglore_multiplex_audi3", AudiSize.MIN,AudiType.IMAX, 50);
        Audi banglore_multiplex_audi4 = createInitAudi("banglore_multiplex_audi4", AudiSize.MIN,AudiType.IMAX, 50);

        audiList.add(banglore_multiplex_audi1);
        audiList.add(banglore_multiplex_audi2);
        audiList.add(banglore_multiplex_audi3);
        audiList.add(banglore_multiplex_audi4);

        return audiList;
    }
    public Theater createMultiplexTheater(){
        Theater multiplexTheater = createInitTheater("Multiplex", TheaterType.MULTIPLEX);
        return multiplexTheater;
    }

    public Theater createMiniTheater(){
        Theater miniTheater = createInitTheater("Multiplex", TheaterType.MINI);
        return miniTheater;
    }

    public Theater createSingleTheater(){
        Theater singleTheater = createInitTheater("Multiplex", TheaterType.SINGLE);
        return singleTheater;
    }

    public Address createBangloreAddress(){
        Address address = createBangloreAddress("ring_road", "Banglore", "karnataka" , "56001","india");
        return address;
    }

    public Address createBangloreAddress(String street, String cityName, String state, String pincode, String country){
        return new Address(street,cityName,state,pincode,country);
    }

    public Address createMysoreAddress(){
        Address address = createMysoreAddress("ring_road", "Mysore", "karnataka" , "570001","india");
        return address;
    }

    public Address createMysoreAddress(String street, String cityName, String state, String pincode, String country){
        return new Address(street,cityName,state,pincode,country);
    }
}
