package io.hieulam.betest.service;

import io.hieulam.betest.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    void delete(long id);
}
