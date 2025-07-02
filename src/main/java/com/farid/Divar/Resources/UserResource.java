package com.farid.Divar.Resources;

import com.farid.Divar.Models.User;

import java.time.LocalDate;

public class UserResource {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private LocalDate dateOfBirth;

  public UserResource(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.dateOfBirth = user.getDateOfBirth();
  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

   public String getLastName() {
    return lastName;
   }

   public LocalDate getDateOfBirth() {
    return dateOfBirth;
   }

   public String getFullName() {
    return firstName + " " + lastName;
   }
}
