package com.activiti.abshar.spring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the User service.
 */
@Controller
public class ActivitiController {

    private static final Logger logger = LoggerFactory.getLogger(ActivitiController.class);
    private static final String VIEW_NAME = "/home";

    @RequestMapping({"/"})
    public String home() {
        return VIEW_NAME;
    }
}
