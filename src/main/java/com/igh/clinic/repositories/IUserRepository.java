package com.igh.clinic.repositories;

import com.igh.clinic.entities.User;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
  @Query(
    "SELECT r FROM Usuario r WHERE r.usuario.usuario = :user AND r.usuarii.contraseña = :password"
  )
  Optional<User> auth(
    @Param("user") String email,
    @Param("password") String password
  );
}
