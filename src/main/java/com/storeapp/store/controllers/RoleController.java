package com.storeapp.store.controllers;

import com.storeapp.store.models.RoleDTO;
import com.storeapp.store.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("")
    public List<RoleDTO> getAllRoles() {
        var roles = roleService.getAllRoles();
        return roles;
    }
}
