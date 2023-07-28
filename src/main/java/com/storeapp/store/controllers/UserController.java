package com.storeapp.store.controllers;

import com.storeapp.store.models.UserDTO;
import com.storeapp.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var userList = userService.getAllUsers();

        if (userList == null || userList.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        if (id <= 0){
            ResponseEntity.badRequest().header("Error", "Invalid user ID").build();
        }
        var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
