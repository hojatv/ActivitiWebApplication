package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import com.activiti.abshar.spring.model.UserModel;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hovaheb on 6/27/2016.
 */
@Controller
public class RuntimeServiceController {
    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping(value = RestURIConstants.START_PROCESS_INSTANCE_BY_KEY, params = {"key"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String startProcessInstanceNyKey(String key) {
        try {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
            return processInstance.getId();
        } catch (Exception e) {
            //TODO return response object for all services
            e.printStackTrace();
        }
        return "";
    }
}
