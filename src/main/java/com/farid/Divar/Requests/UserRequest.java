package com.farid.Divar.Requests;

import com.farid.Divar.Models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "firstName is required")
    @Size(min = 3, message = "firstName must be at least 3 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    private String lastName;


    public User toEntity() {
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);

        return user;
    }
}
