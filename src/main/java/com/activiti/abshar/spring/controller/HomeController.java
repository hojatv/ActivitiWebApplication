package com.activiti.abshar.spring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the User service.
 */
@Controller
public class HomeController {
    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    /**
     * homePage.
     */
    private static final String VIEW_NAME = "/home";

    /**
     * Handles the main web page.
     *
     * @return the view name
     */
    @RequestMapping({"/"})
    public String home() {
        return VIEW_NAME;
    }
}
