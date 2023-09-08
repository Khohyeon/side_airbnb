package com.example.airbnb.module.reservation.model;

import com.example.airbnb.module.lodging.model.Lodging;
import com.example.airbnb.module.reservation.status.ReservationStatus;
import com.example.airbnb.module.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Lodging lodging;
    // TODO : 예약 시간 어떻게 들어오는지 아직 모름
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

}
