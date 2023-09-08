package com.example.airbnb.module.lodging.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LodgingRepository extends JpaRepository<Lodging, Integer> {
}
