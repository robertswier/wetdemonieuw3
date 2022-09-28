package com.example.wetdemonieuw.services;

import com.example.wetdemonieuw.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CustomerService {

    @Value("${backend.url}")
    private URI backend;

    @Value("${backend.urlObject}")
    private URI backendObject;

    public CustomerService() {
    }
    public CustomerService(URI backend) {
        this.backend = backend;
    }

    //Zorg dat je een restTemplate BEAN gebruikt zodat je die kan injecteren en mocken tbv testen
    @Autowired
    RestTemplate restTemplate;

    public Customer getCustomerFromBackendServiceObject() {
        Customer customer = restTemplate.getForObject(backendObject, Customer.class);
        return customer;
    }

    public Customer getCustomerFromBackendServicegetForEntity() {
        ResponseEntity<String> response = restTemplate.getForEntity(backend, String.class);
        System.out.println(response);

        Customer customer = new Customer(response.getBody());
        return customer ;
    }
}
