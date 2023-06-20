package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminUserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Address shippingAddress;
    private String billingAddressId;
    private String phoneNumber;

    private List<String> roles;

    public void setRoles(List<Role> roles) {
        var list = new ArrayList<String>();
        for (Role role : roles) {
            list.add(role.getName());
        }
        this.roles = list;
    }
}
