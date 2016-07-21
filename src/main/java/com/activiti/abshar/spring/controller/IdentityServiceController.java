package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import com.activiti.abshar.spring.model.ActivitiResponse;
import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Activiti Identity Service Controller.
 */
@Controller
public class IdentityServiceController {
    /**
     * identityService.
     */
    private IdentityService identityService;
    /**
     * logger.
     */
    Logger logger = Logger.getLogger(IdentityServiceController.class.getName());

    /**
     * lists all activiti users.
     *
     * @return activiti users.
     */
    @RequestMapping(value = RestURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
    public
    @ResponseBody
    ActivitiResponse getAllUsers() {
        ActivitiResponse activitiResponse = new ActivitiResponse();
        try {
            List<org.activiti.engine.identity.User> users = identityService.createUserQuery().list();
            activitiResponse.setResponse(users);
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, e.toString());
            activitiResponse.setErrorMessage(e.toString());
        }
        return activitiResponse;
    }

    @Autowired
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }
}
