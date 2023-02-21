package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.enums.Role;
import com.softWalter.solicitation.template.user.UserMockFacktory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class RaUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private User user = UserMockFacktory.createNewUser();
    private  final String testFake = "Walter Heitor Test User Update";

    @Test
    @Order(0)
    public void save_user_test(){

        User userTest = userRepository.save(new User(null, "Walterheirtor",
                "whfol@hemail", "123456", Role.END_USER, null, null));
        assertThat(userTest.getId()).isEqualTo(1L);
    }

    @Test
    @Order(1)
    public void update_user_test(){

        user.setId(1L);
        user.setName(testFake);
        User userTest = userRepository.save(user);
        assertThat(userTest.getId()).isEqualTo(1L);
        assertThat(userTest.getName()).isEqualTo(testFake);
    }

    @Test
    @Order(2)
    void get_by_id_test() {

        Optional<User> userTest = userRepository.findById(1L);
        assertThat(userTest.get().getId()).isEqualTo(1L);
        assertThat(userTest.get().getName()).isEqualTo(testFake);
    }

    @Test
    @Order(3)
    void list_users_test() {
        List<User> usersTest = userRepository.findAll();
        assertThat(usersTest.size()).isEqualTo(1);
    }

    @Test
    @Order(4)
    void get_login_test() {
        String email = "walter@gmail.com";
        String password = "123";
        Optional<User> userTest = userRepository.login(email, password);
        assertThat(userTest.get().getId()).isEqualTo(1L);
        assertThat(userTest.get().getName()).isEqualTo(testFake);
        assertThat(userTest.get().getEmail()).isEqualTo(email);
        assertThat(userTest.get().getPassword()).isEqualTo(password);
    }
    @Test
    @Order(5)
    void update_role_test() {
        int affectedRows = userRepository.updateRole(1L, Role.ADMINISTRATOR);
        assertThat(affectedRows).isEqualTo(1);
    }
}