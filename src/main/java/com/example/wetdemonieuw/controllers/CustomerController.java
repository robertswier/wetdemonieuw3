package com.example.wetdemonieuw.controllers;

import com.example.wetdemonieuw.model.Customer;
import com.example.wetdemonieuw.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/serviceapiwithbackendobject",
            produces = "application/json")
    public Customer getCustomerFromBackendObject() {
        Customer response = customerService.getCustomerFromBackendServiceObject();
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/serviceapiwithbackend",
            produces = "application/json")
    public Customer getCustomerFromBackend() {
        Customer response = customerService.getCustomerFromBackendServicegetForEntity();
        return response;
    }
}
