package com.farid.Divar.Requests;

import java.time.LocalDate;
import com.farid.Divar.Models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// @Getter
public class UserRequest {
  
  @NotBlank(message = "firstName is required")
  private String firstName;

  @Size(min = 8, message = "lastName must be at least 3 characters")
  @NotEmpty(message = "lastName is required.")
  private String lastName;

  @NotNull(message = "dateOfBirth is required.")
  private LocalDate dateOfBirth;

  // public String getFirstName() {
  //   return firstName;
  // }

  // public String getLastName() {
  //   return lastName;
  // }

  // public User toUser() {
  //   return new User().setName(fullName).setEmail(email.toLowerCase()).setBirthDate(dateOfBirth)
  //       .setGender(gender).setAddress(address.toAddress());
  // }

  public User toEntity() {
    User user = new User();
    System.out.println("XXXXXXXX");
    System.out.println(this.firstName);
    System.out.println(this);
    System.out.println("YYYYYYY");


    user.setFirstName(this.firstName);
    // user.setEmail(this.email);
    // user.setPassword(this.password); // Optionally hash password here
    
    return user;
  }
}
