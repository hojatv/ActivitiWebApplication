package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import com.activiti.abshar.spring.model.ActivitiResponse;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.rest.service.api.runtime.task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hovaheb on 6/21/2016.
 */

@Controller
public class TaskServiceController {
    @Autowired
    private TaskService taskService;
    Logger logger = Logger.getLogger(TaskServiceController.class.getName());

    @RequestMapping(value = RestURIConstants.GET_TASKS, params = {"taskId"}, method = RequestMethod.GET)
    public
    @ResponseBody
    ActivitiResponse getTasks(String taskId) {
        ActivitiResponse activitiResponse = new ActivitiResponse();
        try {
            Task task = taskService
                    .createTaskQuery()
                    .taskId(taskId)
                    .singleResult();
            TaskResponse response = new TaskResponse(task);
            activitiResponse.setResponse(response);
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE,e.toString());
            activitiResponse.setErrorMessage(e.toString());
        }
        return activitiResponse;
    }
}
