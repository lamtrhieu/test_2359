package io.hieulam.betest.controller;

import io.hieulam.betest.model.User;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.service.ShapeService;
import io.hieulam.betest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ShapeService shapeService;

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

    @GetMapping("/users/{name}/shapes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Shape> getSavedShapesForKid(@PathVariable String name) {
        return shapeService.listSaveShapesForKid(name);
    }

    @PostMapping("/users/{name}/shapes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Shape createShapeForKid(@PathVariable String name, @RequestBody Shape shape) {
        return shapeService.createShapeForKid(name, shape);
    }

    @PutMapping("/users/{name}/shapes/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Shape updateShapeForKid(@PathVariable String name, @RequestBody Shape shape, @PathVariable String id) {
        return shapeService.updateShapeForKid(name, shape, id);
    }

    @DeleteMapping("/users/{name}/shapes/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteShapeForKid(@PathVariable String name, @PathVariable String id) {
        shapeService.deleteShapeForKid(name, id);
    }

}
