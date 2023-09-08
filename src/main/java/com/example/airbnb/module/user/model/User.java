package com.example.airbnb.module.user.model;

import com.example.airbnb.common.BaseTime;
import com.example.airbnb.common.RoleType;
import com.example.airbnb.module.user.status.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USERS")
public class User extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String tel;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User(String email, String password, String name, String tel) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.tel = tel;
    }
}
