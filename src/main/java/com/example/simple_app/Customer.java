package com.example.simple_app;


import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Customer {

    private final String id;
    private final String name;
    private final String address;
    private final String serviceRendered;

    public static List<Customer> customer(){
            return Arrays.asList(
                    Customer.builder().id("someId").address("via di maio 39").name("maio").serviceRendered("true").build()
            );
    }
}
