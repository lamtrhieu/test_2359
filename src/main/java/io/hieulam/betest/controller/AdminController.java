package io.hieulam.betest.controller;

import io.hieulam.betest.model.User;
import io.hieulam.betest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin-management/v1")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/admins")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User createAdmin(@RequestBody User user) {
        return userService.createAdmin(user);
    }

    @RequestMapping("/admins/{name}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAdmin(@PathVariable String name) {
        userService.deleteAdmin(name);
    }

    @DeleteMapping("/logout")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void logout(@RequestBody String token) {
        OAuth2AccessToken access = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(access);
    }


}
