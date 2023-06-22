package com.storeapp.store.controllers;

import com.storeapp.store.services.RoleService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class RoleControllerTest {

    @Mock
    private RoleService roleService;

    @InjectMocks
    RoleController roleController;


    @Test
    void getAllRoles() {
        var expected = TestData.roleDTOList;
        Mockito.when(roleService.getAllRoles()).thenReturn(expected);
        var actual = roleController.getAllRoles();
        assertEquals(expected, actual);
    }

    @Test
    void getAllRolesTestReturnsNull() {
        Mockito.when(roleService.getAllRoles()).thenReturn(new ArrayList<>());
        var actual = roleController.getAllRoles();
        assertEquals(0, actual.size());
    }

}
