package com.farid.Divar.Models;

import com.farid.Divar.Requests.UserRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// @Setter @NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public void updateData(UserRequest user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
    }
}
