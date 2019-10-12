package io.hieulam.betest.service;

import io.hieulam.betest.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);

    UserDetails loadUserByUsername(String username);

    User createAdmin(User user);

    void deleteAdmin(String name);

    User createUser(User user);

    List<User> findAllUsers();



}
