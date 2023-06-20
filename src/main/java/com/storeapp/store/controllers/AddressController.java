package com.storeapp.store.controllers;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("")
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}
