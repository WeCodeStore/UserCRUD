package com.storeapp.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="addressId")
    private long addressId;
    private String city;
    private String street;
    private String state;
    private String postalCode;
    private String country;
    @OneToOne(mappedBy = "shippingAddress")
    @JsonIgnore
    private User userWithShippingAddress;
    @OneToOne(mappedBy = "billingAddress")
    @JsonIgnore
    private User userWithBillingAddress;
}
