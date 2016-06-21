package com.abshar.saadat.spring.controller;
import com.abshar.saadat.spring.model.UserModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Handles requests for the User service.
 */
@Controller
public class ActivitiController {

    private static final Logger logger = LoggerFactory.getLogger(ActivitiController.class);
    private static final String VIEW_NAME = "/home";


    @RequestMapping(value = RestURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
    public
    @ResponseBody
    List<UserModel> getAllEmployees() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<org.activiti.engine.identity.User> users = processEngine.getIdentityService()
                .createUserQuery().list();
        List<UserModel> result = new ArrayList<UserModel>();
        for(org.activiti.engine.identity.User user:users){
            UserModel userModel = new UserModel();
            userModel.setEmail(user.getEmail());
            userModel.setFirstName(user.getFirstName());
            userModel.setLastName(user.getLastName());
            userModel.setId(user.getId());
            userModel.setPassword(user.getPassword());
            result.add(userModel);
        }
        return result;
    }

    @RequestMapping({"/"})
    public String home() {
        return VIEW_NAME;
    }
}
