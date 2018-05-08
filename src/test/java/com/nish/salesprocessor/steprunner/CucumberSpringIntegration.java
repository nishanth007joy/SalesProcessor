package com.nish.salesprocessor.steprunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.nish.salesprocessor.SalesProcessorApplication;

@SpringBootTest(classes = SalesProcessorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("INTEGRATION_TEST")
@ContextConfiguration
public class CucumberSpringIntegration {
	@Autowired
	protected TestRestTemplate template;
}
