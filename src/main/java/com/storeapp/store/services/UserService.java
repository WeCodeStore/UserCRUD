package com.storeapp.store.services;

import com.storeapp.store.models.UserDTO;
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

    ModelMapper mapper = new ModelMapper();

    public List<UserDTO> getAllUsers() {
        var dtoList = new ArrayList<UserDTO>();
        var list = userRepository.findAll();
        if(list.size() > 0) {
            for (User user : list) {
                dtoList.add(mapper.map(user, UserDTO.class));
            }
        }
        return dtoList;
    }

    public UserDTO getUserById(int id) {
        return mapper.map(userRepository.findById(id), UserDTO.class);
    }

    public UserDTO getUserByEmail(String email) {
        var user = userRepository.findByEmail(email);
        if (user != null) {
            return mapper.map(user, UserDTO.class);
        }
        return null;
    }

    public UserDTO saveNewUser(UserDTO newUser) {
        User user = mapper.map(newUser, User.class);
        var savedUser=userRepository.save(user);
        return mapper.map(savedUser, UserDTO.class);
    }
}
