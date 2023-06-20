package com.storeapp.store.services;

import com.storeapp.store.models.AdminUserDTO;
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
            dtoList.add(modelMapper.map(user, AdminUserDTO.class));
        }
        return dtoList;
    }

    public AdminUserDTO getUserById(int id) {
        return modelMapper.map(userRepository.findById(id), AdminUserDTO.class);
    }
}
