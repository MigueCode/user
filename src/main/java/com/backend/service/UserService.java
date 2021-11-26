package com.backend.service;

import com.backend.model.User;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer id){
        return userRepository.getUser(id);
    }

    public User signUpUser(User user){
        if (!(user.getId() == null)) return user;
        if (existsEmail(user.getEmail())) return user;
        return userRepository.save(user);
    }

    public boolean existsEmail(String email){
        if (userRepository.existsEmail(email).isEmpty()){
            return false;
        }

        return true;

    }

    public User existsUser(String email, String password){
        Optional<User> user = userRepository.existsUser(email, password);

        if (user.isEmpty()) return new User(email, password,"NO DEFINIDO");

        return user.get();
    }
}
