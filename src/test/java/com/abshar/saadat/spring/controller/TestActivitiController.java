package com.abshar.saadat.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class TestActivitiController {

    public static final String SERVER_URI = "http://localhost:8080/EmbeddedActivitiWebApplication";

    @Before
    public void setUp() {

    }
    @Test
    public void testGetAllEmployee() {
        RestTemplate restTemplate = new RestTemplate();
    }
}
