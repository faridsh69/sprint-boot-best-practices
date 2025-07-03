package com.farid.Divar.Models;

import java.time.LocalDate;
import com.farid.Divar.Requests.UserRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// @Setter @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Entity @Table(name = "users2")
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;

  public void updateData(UserRequest user) {
    // firstName = user.getFirstName();
    // lastName = user.getLastName();
  }
}
