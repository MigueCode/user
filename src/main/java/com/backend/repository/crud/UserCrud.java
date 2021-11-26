package com.backend.repository.crud;

import com.backend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrud extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
