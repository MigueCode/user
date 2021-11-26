package com.backend.controller;

import com.backend.model.User;
import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUpUser(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @GetMapping("/{email}/{password}")
    public User existsUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.existsUser(email, password);
    }

    @GetMapping("/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return userService.existsEmail(email);
    }
}
