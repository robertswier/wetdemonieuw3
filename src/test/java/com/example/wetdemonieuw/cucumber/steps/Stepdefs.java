package com.example.wetdemonieuw.cucumber.steps;

import com.example.wetdemonieuw.controllers.CustomerController;
import com.example.wetdemonieuw.model.Customer;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class Stepdefs {

    @Autowired
    CustomerController customerController;

    Customer customer;

    @When("a customer is requested")
    public void aCustomerIsRequested() {
        customer = customerController.getCustomerFromBackend();
    }

    @Then("a customer is received")
    public void customerReceived() {
//        fail();
        assertNotNull(customer);
    }
}
