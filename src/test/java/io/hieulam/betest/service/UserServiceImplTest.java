package io.hieulam.betest.service;

import io.hieulam.betest.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserServiceImpl();
    }

    @Test
    void shouldLoadUserByUsername() {
        userService.createUser(new User("test", "test"));

        UserDetails userDetails = userService.loadUserByUsername("test");
        assertThat(userDetails.getUsername()).isEqualTo("test");
        assertThat(userDetails.getAuthorities().size()).isEqualTo(1);
    }

    @Test
    public void shouldLoadAdminByUserName() {
        userService.createAdmin(new User("admin", "admin"));

        UserDetails userDetails = userService.loadUserByUsername("admin");
        assertThat(userDetails.getUsername()).isEqualTo("admin");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        assertThat(authorities.size()).isEqualTo(2);
    }

    @Test
    public void shouldThrowExceptionIfCannotLoadUser() {
        //when
        Throwable thrown = catchThrowable(() -> {
            userService.loadUserByUsername("notexist");
        });

        // then
        assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("Invalid username or password.");
    }


    @Test
    void shouldFindUserByUsername() {
        User user = new User("hieu", "hieu");
        userService.createUser(user);
        User result = userService.findUserByUsername("hieu");

        assertThat(result.getUsername()).isEqualTo("hieu");
        assertThat(result.getPassword()).startsWith("$2a$10");
    }

    @Test
    void shouldCreateAdmin() {
        userService.createAdmin(new User("test1", "test1"));

        assertThat(userService.loadUserByUsername("test1").getAuthorities()).hasSize(2);
    }

    @Test
    void shouldDeleteAdmin() {
        userService.createAdmin(new User("test1", "test1"));
        assertThat(userService.loadUserByUsername("test1").getAuthorities()).hasSize(2);

        userService.deleteAdmin("test1");

        Throwable thrown = catchThrowable(() -> {
            userService.loadUserByUsername("test1");
        });

        // then
        assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("Invalid username or password.");


    }

    @Test
    void shouldNotDeleteDefaultAdmin() {
        Throwable thrown = catchThrowable(() -> {
            userService.deleteAdmin("super_admin");
        });

        // then
        assertThat(thrown)
                .isInstanceOf(AccessDeniedException.class)
                .hasMessageContaining("Cannot delete the super admin.");
    }

    @Test
    void shouldThrowExceptionWhenCannotDeleteAdmin() {
        Throwable thrown = catchThrowable(() -> {
            userService.deleteAdmin("notexist");
        });

        // then
        assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("Cannot find admin with username: notexist");
    }


    @Test
    void createUser() {
        userService.createUser(new User("test1", "test1"));
        userService.createUser(new User("test2", "test2"));

        assertThat(userService.findAllUsers().size()).isEqualTo(4);
    }

    @Test
    void findAllUsers() {
        userService.createUser(new User("test1", "test1"));
        userService.createUser(new User("test2", "test2"));

        assertThat(userService.findAllUsers().size()).isEqualTo(4);
    }
}