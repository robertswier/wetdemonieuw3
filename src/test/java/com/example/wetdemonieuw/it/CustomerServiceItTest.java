package com.example.wetdemonieuw.it;

import com.example.wetdemonieuw.model.Customer;
import com.example.wetdemonieuw.services.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceItTest {

    @Autowired
    CustomerService customerService;

    @MockBean
    RestTemplate restTemplateMock;

    @Before
    public void setUp() {
    }

    @Test
    void getCustormerFromBackendServiceForEntity() {
        when(restTemplateMock.getForEntity(any(), any())).thenReturn(new ResponseEntity("naampje", HttpStatus.OK));
        Customer response = customerService.getCustomerFromBackendServicegetForEntity();
        System.out.println(response);
        assertNotNull(response);
    }

    @Test
    void getCustormerFromBackendService() {
        when(restTemplateMock.getForObject(any(), any())).thenReturn(new Customer("it test"));
        Customer response = customerService.getCustomerFromBackendServiceObject();
        System.out.println(response);
        assertNotNull(response);
    }
}