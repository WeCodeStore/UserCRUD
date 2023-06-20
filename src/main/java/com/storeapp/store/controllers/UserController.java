package com.storeapp.store.controllers;

import com.storeapp.store.models.AdminUserDTO;
import com.storeapp.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AdminUserDTO> getAllUsers() {
        var userList = userService.getAllUsers();
        return userList;
    }

    @GetMapping("/{id}")
    public AdminUserDTO getUserById(@PathVariable String id) {
        int userId = 0;
        try {
            userId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
        }
        return userService.getUserById(userId);
    }
}
