package com.example.airbnb.module.lodging.controller;

import com.example.airbnb.exception.Exception400;
import com.example.airbnb.module.lodging.dto.LodgingSaveRequest;
import com.example.airbnb.module.lodging.model.Lodging;
import com.example.airbnb.module.lodging.service.LodgingService;
import com.example.airbnb.module.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/lodging")
public class LodgingController {

    private final LodgingService lodgingService;
    private final UserService userService;

    public LodgingController(LodgingService lodgingService, UserService userService) {
        this.lodgingService = lodgingService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Lodging> save(@Valid @RequestBody LodgingSaveRequest request) {

        //TODO : security 적용 후 jwt 유저 정보 받아서 service에 user Id, address Id 넘겨 줄 것.
//        userService.getUser()

        Optional<Lodging> optionalLodging = lodgingService.save();

        if (optionalLodging.isEmpty()) {
            throw new Exception400("숙소등록에 올바르게 진행되지 않으셨습니다.");
        }

        return ResponseEntity.ok().body(optionalLodging.get());
    }
}
