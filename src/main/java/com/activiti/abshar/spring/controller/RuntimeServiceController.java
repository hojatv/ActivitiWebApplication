package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import com.activiti.abshar.spring.model.ActivitiResponse;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Activiti Runtime Service Controller.
 */
@Controller
public class RuntimeServiceController {
    /**
     * runtime service.
     */
    private RuntimeService runtimeService;
    /**
     * logger.
     */
    Logger logger = Logger.getLogger(RuntimeServiceController.class.getName());

    /**
     * starts a process instance defined by process key.
     *
     * @param key process key.
     * @return processInstance Id.
     */
    @RequestMapping(value = RestURIConstants.START_PROCESS_INSTANCE_BY_KEY, params = {"key"}, method = RequestMethod.GET)
    public
    @ResponseBody
    ActivitiResponse startProcessInstanceNyKey(String key) {
        ActivitiResponse activitiResponse = new ActivitiResponse();
        try {
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
            activitiResponse.setResponse(processInstance.getId());
            return activitiResponse;
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, e.toString());
            activitiResponse.setErrorMessage(e.toString());
        }
        return activitiResponse;
    }

    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
}
