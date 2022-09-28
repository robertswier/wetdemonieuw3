package com.example.wetdemonieuw.services;

import com.example.wetdemonieuw.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//Je hebt mockito nodig in je JUnit test om fields te kunnen mocken, bijv als er dmv @Autowired beans zijn gebruikt
@ExtendWith(MockitoExtension.class)
class CustomerServiceUnitTest {

    //Voor de instance onder test gebruik je @InjectMocks om de mocks te injecteren
    @InjectMocks
    CustomerService testable;
    {
        try {
            testable = new CustomerService(new URI("http://dummy"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //Wordt geinjecteerd in de @InjectMocks instance
    @Mock
    RestTemplate restTemplateMock;

    @Test
    void getCustormerFromBackendService() {
        String testName = "testCustomer";
        when(restTemplateMock.getForObject(any(), any())).thenReturn(new Customer(testName));
        Customer result = testable.getCustomerFromBackendServiceObject();
        assertTrue(testName.equals(result.getName()));
    }
}