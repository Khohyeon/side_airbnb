package com.example.airbnb.module.user.model;

import com.example.airbnb.module.user.status.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String name;
    private String email;
    private String tel;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User(String password, String name, String email, String tel) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
    }
}
