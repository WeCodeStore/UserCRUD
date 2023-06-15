package com.storeapp.store.services;

import com.storeapp.store.models.AdminUserDTO;
import com.storeapp.store.models.Role;
import com.storeapp.store.models.User;
import com.storeapp.store.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<AdminUserDTO> getAllUsers() {

        var dtoList = new ArrayList<AdminUserDTO>();
        var list = userRepository.findAll();
        for (User user : list) {
            var newUser = modelMapper.map(user, AdminUserDTO.class);
            var roleList = new ArrayList<String>();
            for (Role role : user.getRoles()) {
                roleList.add(role.getName());
            }
            newUser.setRoles(roleList);
            dtoList.add(newUser);
        }
        return dtoList;
    }
}
