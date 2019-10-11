package io.hieulam.betest.service;

import io.hieulam.betest.model.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private Map<String, User> userMap;

    private Map<String, User> adminMap;

    private static final String SUPER_ADMIN_NAME = "super_admin";

    private static final String SUPER_ADMIN_PASS = "super_pass";

    public UserServiceImpl() {
        this.userMap = new HashMap<>();
        this.adminMap = new HashMap<>();


        User seedAdmin = new User(SUPER_ADMIN_NAME, encryptPassword(SUPER_ADMIN_PASS));
        adminMap.put(SUPER_ADMIN_NAME, seedAdmin);
    }

    public String encryptPassword(String rawPass) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(rawPass);

        return encode;
    }

//    @Override
//    public User save(User user) {
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public void delete(long id) {
//
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (isAdmin(username)) {
            User user = adminMap.get(username);
            List<GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        } else if (isUser(username)) {
            User user = userMap.get(username);
            List<GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

//        User user = userMap.get(username);
//        userMap.values().stream().filter(user -> user.getUsername() == username).count();

//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private boolean isUser(String userName) {
        return userMap.containsKey(userName);
    }

    private boolean isAdmin(String adminName) {
        return adminMap.containsKey(adminName);
    }


//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        User user = userDao.findByUsername(userId);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
//    }

//    private List<SimpleGrantedAuthority> getAuthority() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
//    }

    @Override
    public User findUserByUsername(String username) {
        return userMap.get(username);
    }

    @Override
    public User createAdmin(User user) {
        encryptUserPassword(user);
        adminMap.put(user.getUsername(), user);
        return user;
    }

    private void encryptUserPassword(User user) {
        String rawPass = user.getPassword();
        user.setPassword(encryptPassword(rawPass));
    }

    @Override
    public void deleteAdmin(String username) {
        if (!adminMap.containsKey(username)) {
            throw new UsernameNotFoundException("Cannot find admin with username: " + username);
        } else if (username.equals(SUPER_ADMIN_NAME)) {
            throw new AccessDeniedException("Cannot delete the super admin.");
        }
        adminMap.remove(username);
    }

    @Override
    public User createUser(User user) {
        encryptUserPassword(user);
        userMap.put(user.getUsername(), user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList(userMap.values());
        users.addAll(adminMap.values());

        return users;
    }
}
