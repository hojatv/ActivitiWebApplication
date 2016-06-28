package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.model.ActivitiResponse;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

/**
 * Created by hovaheb on 6/28/2016.
 */
public class IdentityServiceControllerTest {
    IdentityServiceController identityServiceController;
    @Mock
    IdentityService identityService;
    private java.util.List<org.activiti.engine.identity.User> users;
    @Mock
    private org.activiti.engine.identity.UserQuery userQuery;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        identityServiceController = new IdentityServiceController();
        identityServiceController.setIdentityService(identityService);
        users = new ArrayList<User>();
        users.add(new UserEntity("1"));
    }

    @Test
    public void testGetAllUsers() {
        Mockito.when(identityService.createUserQuery()).thenReturn(userQuery);
        Mockito.when(userQuery.list()).thenReturn(users);
        ActivitiResponse activitiResponse = new ActivitiResponse();
        activitiResponse.setResponse(users);
        ActivitiResponse result = identityServiceController.getAllUsers();
        Assert.assertEquals("testGetAllUsers", result.getResponse().toString(), activitiResponse.getResponse().toString());
    }

    @Test
    public void testSetIdentityService() {
        identityServiceController.setIdentityService(identityService);
    }
}
