package com.storeapp.store.services;

import com.storeapp.store.models.Role;
import com.storeapp.store.models.RoleDTO;
import com.storeapp.store.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    ModelMapper modelMapper = new ModelMapper();
    public List<RoleDTO> getAllRoles() {
        var dtoList = new ArrayList<RoleDTO>();
        var list = roleRepository.findAll();
        for (Role role : list) {
            dtoList.add(modelMapper.map(role, RoleDTO.class));
        }
        return dtoList;
    }
}
