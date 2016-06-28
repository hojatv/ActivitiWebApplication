package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.model.ActivitiResponse;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by hovaheb on 6/28/2016.
 */
public class RuntimeServiceControllerTest {
    RuntimeServiceController runtimeServiceController;
    @Mock
    RuntimeService runtimeService;
    @Mock
    ProcessInstance processInstance;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        runtimeServiceController = new RuntimeServiceController();
        runtimeServiceController.setRuntimeService(runtimeService);
    }

    @Test
    public void testStartProcessInstanceNyKey(){
        Mockito.when(runtimeService.startProcessInstanceByKey("test")).thenReturn(processInstance);
        Mockito.when(processInstance.getId()).thenReturn("1");
        ActivitiResponse result = runtimeServiceController.startProcessInstanceNyKey("test");
        ActivitiResponse activitiResponse = new ActivitiResponse();
        activitiResponse.setResponse("1");
        Assert.assertEquals("ProcessInstance processInstance", activitiResponse.getResponse().toString(),result.getResponse().toString() );

    }
    @Test
    public void testSetRuntimeSerivce(){
        runtimeServiceController.setRuntimeService(runtimeService);
    }
}
