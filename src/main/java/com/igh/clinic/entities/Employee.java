package com.igh.clinic.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Data
public class Employee {

  @Id
  private Long id;

  private String name;
  private String lastname;
  private Long dni;
  private String email;
  private Long cel;

  @MappedCollection(idColumn = "id_user")
  private User user;
}
