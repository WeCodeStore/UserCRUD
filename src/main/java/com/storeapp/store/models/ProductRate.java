package com.storeapp.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




public class ProductRate {
    private double rates;
    private long count;

    public ProductRate(double rates, long count) {
        this.rates = rates;
        this.count = count;
    }

    public double getRates() {
        return rates;
    }

    public long getCount() {
        return count;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
