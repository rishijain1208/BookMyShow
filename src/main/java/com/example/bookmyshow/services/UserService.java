package com.example.bookmyshow.services;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User createUser(String email)
    {
        User user = new User();
        user.setEmail(email);

        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
