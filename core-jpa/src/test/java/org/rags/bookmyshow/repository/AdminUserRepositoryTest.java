package org.rags.bookmyshow.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AdminUserRepositoryTest {

    @Autowired
    AdminUserRepository adminUserRepository;

    @BeforeEach
    void setUp() {

    }

//    @Test
//    public void adminUserTest(){
//        AdminUser adminUser = new AdminUser( "ram","ram@nomail.com","343434",UUID.randomUUID(),"12345");
//        AdminUser saved = adminUserRepository.save(adminUser);
//        Assertions.assertThat(saved).isNotNull();
//        Assertions.assertThat(saved.getAdminId()).isNotNull();
//
//    }
}