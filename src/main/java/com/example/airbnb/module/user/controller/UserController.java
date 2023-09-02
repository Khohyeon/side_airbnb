package com.example.airbnb.module.user.controller;

import com.example.airbnb.exception.Exception400;
import com.example.airbnb.module.user.dto.UserJoinRequest;
import com.example.airbnb.module.user.dto.UserLoginRequest;
import com.example.airbnb.module.user.model.User;
import com.example.airbnb.module.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public ResponseEntity<User> join(@Valid @RequestBody UserJoinRequest request, BindingResult result) {

        if (result.hasErrors()) {
            throw new Exception400(result.getAllErrors().get(0).getDefaultMessage());
        }

        User user = userService.userJoin(request);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody UserLoginRequest request, BindingResult result) {

        if (result.hasErrors()) {
            throw new Exception400(result.getAllErrors().get(0).getDefaultMessage());
        }

        Optional<User> optionalUser = userService.userLogin(request);

        if (optionalUser.isEmpty()) {
            throw new Exception400("이메일과 비밀번호를 다시 확인 해주세요.");
        }

        return ResponseEntity.ok().body(optionalUser.get());
    }

}
