package com.example.wetdemonieuw.model;

import lombok.Data;

//@Setter
//@Getter
@Data
public class Customer {
    String name;

    public Customer(final String name) {
        this.name = name;
    }
    public Customer() {}
}
