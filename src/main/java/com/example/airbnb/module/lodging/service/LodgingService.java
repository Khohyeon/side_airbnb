package com.example.airbnb.module.lodging.service;

import com.example.airbnb.module.lodging.model.Lodging;
import com.example.airbnb.module.lodging.model.LodgingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LodgingService {

    private final LodgingRepository lodgingRepository;


    public LodgingService(LodgingRepository lodgingRepository) {
        this.lodgingRepository = lodgingRepository;
    }

    public Optional<Lodging> save() {
        return null;
    }
}
