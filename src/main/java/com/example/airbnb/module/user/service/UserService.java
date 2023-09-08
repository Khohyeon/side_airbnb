package com.example.airbnb.module.user.service;

import com.example.airbnb.module.user.dto.UserJoinRequest;
import com.example.airbnb.module.user.dto.UserLoginRequest;
import com.example.airbnb.module.user.model.User;
import com.example.airbnb.module.user.model.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User userJoin(UserJoinRequest request) {
        String encodePassword = passwordEncoder.encode(request.password());
        return userRepository.save(request.toEntity(encodePassword));

    }

    public Optional<User> userLogin(UserLoginRequest request) {
        return userRepository.findByEmailAndPassword(request.email(), request.password());
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }
}
