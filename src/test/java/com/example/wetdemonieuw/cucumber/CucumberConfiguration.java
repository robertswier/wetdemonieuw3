package com.example.wetdemonieuw.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
//@DirtiesContext
@CucumberContextConfiguration
public class CucumberConfiguration {
}
