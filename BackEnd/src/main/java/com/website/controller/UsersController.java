package com.website.controller;

import com.website.model.User;
import com.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path="/api/v1/users")
public class UsersController {
    @Autowired
    UserRepository repository;

    @GetMapping
    public @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody User getUserById(@PathVariable long id) { return repository.findById(id).orElse(null); }

    @GetMapping("/user/{username}")
    public @ResponseBody User getUserByUsername(@PathVariable String username) { return repository.findByUsername(username).orElse(null); }
}
