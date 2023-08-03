package com.storeapp.store.controllers;

import com.storeapp.store.models.LoginDTO;
import com.storeapp.store.models.UserDTO;
import com.storeapp.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerNewUser(@RequestBody UserDTO newUser) {
        var userDTO = userService.saveNewUser(newUser);
        return ResponseEntity.ok(userService.saveNewUser(newUser));
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
