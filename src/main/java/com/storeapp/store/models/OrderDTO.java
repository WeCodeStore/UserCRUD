package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private long orderId;
    private long userId;
    private long orderNumber;
    private LocalDate orderDate;
    private List<String> products;
    private double totalPrice;

    public void setProducts(List<Product> products) {
        var list = new ArrayList<String>();
        for (Product product : products) {
            list.add(product.getName());
        }
        this.products = list;
    }
}
