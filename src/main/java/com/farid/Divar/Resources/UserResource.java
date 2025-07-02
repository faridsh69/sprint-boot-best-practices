package com.farid.Divar.Resources;

import com.farid.Divar.Models.User;

public class UserResource {
  private Integer id;
  private String firstName;
  private String lastName;

  public UserResource(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  // public String getLastName() {
  // return lastName;
  // }
}
