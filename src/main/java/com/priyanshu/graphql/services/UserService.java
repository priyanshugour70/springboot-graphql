package com.priyanshu.graphql.services;

import com.priyanshu.graphql.entities.User;
import com.priyanshu.graphql.helper.ExceptionHelper;
import com.priyanshu.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Creating User
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // getting all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // getting single user
    public User getSingleUser(int userId) {
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    // updating user
    // TODO :: Update user

    // deleting user
    public boolean deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);;
        userRepo.delete(user);
        return true;
    }
}
