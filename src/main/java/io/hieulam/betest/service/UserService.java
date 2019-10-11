package io.hieulam.betest.service;

import io.hieulam.betest.model.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);

    User createAdmin(User user);

    void deleteAdmin(String name);

    User createUser(User user);

    List<User> findAllUsers();

//
//    User createAdmin();
//
//    User deleteAdmin();
}
