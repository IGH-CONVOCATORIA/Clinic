package com.igh.clinic.services;

import com.igh.clinic.entities.User;
import com.igh.clinic.repositories.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

  @Autowired
  private IUserRepository userRepository;

  public User registrar(User user) {
    return userRepository.save(user);
  }

  public List<User> listarUser() {
    return (List<User>) userRepository.findAll();
  }

  public User actualizar(User user) {
    return userRepository.save(user);
  }

  public void eliminar(Long id) {
    User user = userRepository.findById(id).orElseThrow();
    userRepository.delete(user);
  }

  public User findById(Long id) {
    return userRepository.findById(id).get();
  }

  public Optional<User> auth(String email, String password) {
    return userRepository.auth(email, password);
  }
}
