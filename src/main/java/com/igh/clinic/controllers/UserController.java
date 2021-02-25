package com.igh.clinic.controllers;

import com.igh.clinic.entities.User;
import com.igh.clinic.repositories.IuserService;
import com.igh.clinic.services.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  public UserController() {
    super();
  }

  @GetMapping
  public List<User> getAllUsers() {
    return (List<User>) userService.listarUser();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(
    @PathVariable(value = "id") final Long userId
  ) {
    User user = userService
      .findById(userId)
      .orElseThrow(
        () -> new NoSuchElementException("User not available for id: " + userId)
      );
    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@Validated @RequestBody User user) {
    userService.actualizar(user);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateUser(
    @PathVariable("id") final Long userId,
    @RequestBody final User user
  ) {
    User findUser = userService
      .findById(userId)
      .orElseThrow(
        () -> new NoSuchElementException("User not available for id: " + userId)
      );
    userService.actualizar(user);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable("id") final Long userId) {
    User user = userService
      .findById(userId)
      .orElseThrow(
        () -> new NoSuchElementException("User not available for id:" + userId)
      );
    userService.eliminar(userId);
  }
}
