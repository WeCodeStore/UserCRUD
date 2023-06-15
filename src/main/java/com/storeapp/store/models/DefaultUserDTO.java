package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DefaultUserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String shippingAddressId;
    private String billingAddressId;
    private String phoneNumber;
}
