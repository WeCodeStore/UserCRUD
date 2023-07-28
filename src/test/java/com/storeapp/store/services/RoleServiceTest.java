//package com.storeapp.store.services;
//
//import com.storeapp.store.repository.RoleRepository;
//import com.storeapp.store.utils.TestData;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//
//
// *******Role to be removed********
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class RoleServiceTest {
//
//    @Mock
//    RoleRepository roleRepository;
//
//    @InjectMocks
//    RoleService roleService;
//
//    @Test
//    void getAllRolesTest() {
//        Mockito.when(roleRepository.findAll()).thenReturn(TestData.roleList);
//        var actual = roleService.getAllRoles();
//        assertEquals("admin", actual.get(0).getName());
//    }
//
//    @Test
//    void getAllRolesTestReturnsEmptyList() {
//        Mockito.when(roleRepository.findAll()).thenReturn(new ArrayList<>());
//        var actual = roleService.getAllRoles();
//        assertEquals(0, actual.size());
//    }
//}