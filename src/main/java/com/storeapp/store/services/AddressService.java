package com.storeapp.store.services;

import com.storeapp.store.models.Address;
import com.storeapp.store.models.AddressDTO;
import com.storeapp.store.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<AddressDTO> getAllAddresses() {
        var addressList = addressRepository.findAll();
        var dtoList = new ArrayList<AddressDTO>();
        for(Address address: addressList) {
            dtoList.add(modelMapper.map(address, AddressDTO.class));
        }
        return dtoList;
    }
}
