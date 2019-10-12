package io.hieulam.betest.controller;

import io.hieulam.betest.model.User;
import io.hieulam.betest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @GetMapping("/api/user/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User user(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        return user;
    }

    @PostMapping("/users/register")
    public User register(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/test")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
