package org.rags.bookmyshow.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.rags.bookmyshow.entity.*;
import org.rags.bookmyshow.stub.BaseBookMyShowStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"org.rags.bookmyshow"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookMyShowAppRepositoryTest extends BaseBookMyShowStub {

    private static Logger logger = LoggerFactory.getLogger(BookMyShowAppRepositoryTest.class.getName());

    @Autowired
    BookMyShowAppRepository bookMyShowAppRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void adminUserTest(){
        BookMyShowApp bookMyShowApp = createBookMyShowApp();
        BookMyShowApp saved = bookMyShowAppRepository.save(bookMyShowApp);
        Assertions.assertThat(saved).isNotNull();
        logger.info("BookMyShowApp Id = " + saved.getBookMyShowAppId().toString());

        Assertions.assertThat(saved.getBookMyShowAppId()).isNotNull();
        Assertions.assertThat(saved.getAdminUsers()).isNotNull();

        List<AdminUser> adminUsers = saved.getAdminUsers();
        Assertions.assertThat(adminUsers.size()).isEqualTo(1);
        logger.info("Total Admin Users = " + adminUsers.size());

        Assertions.assertThat(saved.getCustomerUsers()).isNotNull();
        Collection<CustomerUser> customerUsers = saved.getCustomerUsers();
        Assertions.assertThat(saved.getCustomerUsers().size()).isEqualTo(2);

        logger.info("Total Customer Usres = "+customerUsers.size());

        Assertions.assertThat(saved.getTheaterUsers()).isNotNull();
        Collection<TheaterUser> theaterUsers = saved.getTheaterUsers();
        Assertions.assertThat(theaterUsers.size()).isEqualTo(2);

        logger.info("Total Theater Users size = "+ theaterUsers.size());

        Assertions.assertThat(saved.getTheaterList()).isNotNull();
        Collection<Theater> theaters = saved.getTheaterList();
        Assertions.assertThat(saved.getTheaterList().size()).isEqualTo(3);

        logger.info("Total Theaters added = "+saved.getTheaterUsers().size());

    }
}