package com.backend.repository;

import com.backend.model.User;
import com.backend.repository.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrud userCrud;

    public List<User> getAll(){
        return (List<User>) userCrud.findAll();
    }

    public Optional<User> getUser(Integer id){
        return userCrud.findById(id);
    }

    public User save(User user){
        return userCrud.save(user);
    }

    public Optional<User> existsEmail(String email){
        return userCrud.findByEmail(email);
    }

    public Optional<User> existsUser(String email, String password){
        return userCrud.findByEmailAndPassword(email, password);
    }
}
