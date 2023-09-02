package com.example.airbnb.module.user.service;

import com.example.airbnb.module.user.dto.UserJoinRequest;
import com.example.airbnb.module.user.dto.UserLoginRequest;
import com.example.airbnb.module.user.model.User;
import com.example.airbnb.module.user.model.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User userJoin(UserJoinRequest request) {
        return userRepository.save(request.toEntity());

    }

    public Optional<User> userLogin(UserLoginRequest request) {
        return userRepository.findByEmailAndPassword(request.email(), request.password());
    }
}
