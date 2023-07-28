package com.storeapp.store.controllers;

import com.storeapp.store.models.LoginDTO;
import com.storeapp.store.models.UserDTO;
import com.storeapp.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/store")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody UserDTO newUser) {
        var user = userService.saveNewUser(newUser);
        return ResponseEntity.created(URI.create("/store/users/" + user.getUserId())).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> logInUser(@RequestBody LoginDTO loginDTO) {
        var user = userService.getUserByEmail(loginDTO.getEmail());
        if(user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

}
