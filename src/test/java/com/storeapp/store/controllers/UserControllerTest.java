package com.storeapp.store.controllers;

import com.storeapp.store.models.AdminUserDTO;
import com.storeapp.store.services.UserService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsersTest() {
        var expected = TestData.adminUserDTO;
        List<AdminUserDTO> expectedList = new ArrayList<>();
        expectedList.add((expected));
        Mockito.when(userService.getAllUsers()).thenReturn(expectedList);
        ResponseEntity<List<AdminUserDTO>> actualList = userController.getAllUsers();
        assertEquals(expectedList.get(0).getFirstName(), actualList.getBody().get(0).getFirstName());
    }

    @Test
    void getAllUsersTestReturnNull() {
        Mockito.when(userService.getAllUsers()).thenReturn(null);
        ResponseEntity<List<AdminUserDTO>> actual = userController.getAllUsers();
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

    @Test
    void getUserByIdTest() {
        int userId = 1;
        Mockito.when(userService.getUserById(1)).thenReturn(TestData.adminUserDTO);
        var result = userController.getUserById("1");
        assertEquals("John", result.getBody().getFirstName());
    }

}
