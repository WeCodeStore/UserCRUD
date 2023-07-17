package com.storeapp.store.controllers;

import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        var addresses = addressService.getAllAddresses();
        if (addresses == null || addresses.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(addresses);
    }
}
