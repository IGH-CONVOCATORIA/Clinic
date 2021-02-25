package com.igh.clinic.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class User {

  @Id
  private Long id;

  private String name;
  private String username;
  private String password;
}
