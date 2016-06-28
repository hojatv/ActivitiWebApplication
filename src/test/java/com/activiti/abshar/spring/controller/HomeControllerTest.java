package com.activiti.abshar.spring.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class HomeControllerTest {
    HomeController homeController;

    @Before
    public void setup() {
        homeController = new HomeController();
    }

    @Test
    public void testHome() {
        Assert.assertEquals("testHome", "/home", homeController.home());
    }
}
