package com.storeapp.store.services;

import com.storeapp.store.models.AdminUserDTO;
import com.storeapp.store.models.User;
import com.storeapp.store.repository.UserRepository;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


        @Test
        public void testGetAllUsers () {
            // Create a list of users for testing
            List<User> userList = new ArrayList<>();
            userList.add(TestData.user);

            // Mock the behavior of userRepository.findAll()
            when(userRepository.findAll()).thenReturn(userList);

            // Invoke the method being tested
            List<AdminUserDTO> result = userService.getAllUsers();
            // Assert the result
            assertEquals(userList.size(), result.size());

            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                AdminUserDTO dto = result.get(i);

                assertEquals(user.getFirstName(), dto.getFirstName());

            }
        }


        @Test
        void getAllUsersTestReturnEmptyList () {
            when(userRepository.findAll()).thenReturn(new ArrayList<>());
            List<AdminUserDTO> result = userService.getAllUsers();
            assertEquals(0, result.size());
        }

        @Test
        void getUserByIdTest () {
            int userId = 1;

            when(userRepository.findById(1)).thenReturn(Optional.ofNullable((TestData.user)));

            // Act
            AdminUserDTO actualDto = userService.getUserById(userId);

            assertEquals("John", actualDto.getFirstName());
            verify(userRepository, times(1)).findById(userId);

        }
    }

