package com.storeapp.store.controllers;

import com.storeapp.store.models.RoleDTO;
import com.storeapp.store.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        var roles = roleService.getAllRoles();

        if (roles == null || roles.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(roles);
    }
}
