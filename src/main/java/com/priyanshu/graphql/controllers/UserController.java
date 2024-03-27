package com.priyanshu.graphql.controllers;


import com.priyanshu.graphql.entities.User;
import com.priyanshu.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create user api ...
    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone, @Argument String address, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setPassword(password);
        return userService.createUser(user);
    }

    // get all users
    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get single user:
    public User getSingleUser(@Argument int userId) {
        return userService.getSingleUser(userId);
    }

    // delete user
    @MutationMapping
    public boolean deleteUser(@Argument int userId) {
        return userService.deleteUser(userId);
    }
}
