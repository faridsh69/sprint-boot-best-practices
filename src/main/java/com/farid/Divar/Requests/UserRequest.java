package com.farid.Divar.Requests;

import com.farid.Divar.Configs.Gender;
import com.farid.Divar.Library.Requests.BaseRequest;
import com.farid.Divar.Models.User;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest extends BaseRequest<User> {

    @NotBlank(message = "firstName is required")
    @Size(min = 2, message = "firstName must be at least 2 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "password is required")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "Password must be at least 6 characters and contain both letters and numbers"
    )
    private String password;

    @NotNull(message = "Gender is required")
    private Gender gender;

    private boolean active;
}
