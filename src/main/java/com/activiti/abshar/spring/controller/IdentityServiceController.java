package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import com.activiti.abshar.spring.model.UserModel;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IdentityServiceController {

    @Autowired
    private IdentityService identityService;

    @RequestMapping(value = RestURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
    public
    @ResponseBody
    List<UserModel> getAllUsers() {
        List<org.activiti.engine.identity.User> users = identityService.createUserQuery().list();
        List<UserModel> result = new ArrayList<UserModel>();
        for (org.activiti.engine.identity.User user : users) {
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
}
