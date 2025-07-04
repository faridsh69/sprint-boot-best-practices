package com.farid.Divar.Models;

import com.farid.Divar.Configs.Gender;
import com.farid.Divar.Requests.UserRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private boolean active = false;
    private LocalDate birthDate;

    public void updateData(UserRequest user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
    }
}
