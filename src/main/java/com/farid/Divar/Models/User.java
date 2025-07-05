package com.farid.Divar.Models;

import com.farid.Divar.Configs.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Blog> blogs = new ArrayList<>();
}
