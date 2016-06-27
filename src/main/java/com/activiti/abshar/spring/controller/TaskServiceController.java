package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.common.RestURIConstants;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.rest.service.api.runtime.task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hovaheb on 6/21/2016.
 */

@Controller
public class TaskServiceController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = RestURIConstants.GET_TASKS, params = {"taskId"}, method = RequestMethod.GET)
    public
    @ResponseBody
    TaskResponse getTasks(String taskId) {
        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();*/
        try {
            Task task = taskService
                    .createTaskQuery()
                    .taskId(taskId)
                    .singleResult();
            TaskResponse response = new TaskResponse(task);
            return response;
        } catch (Exception e) {
            //TODO return response object for all services
            e.printStackTrace();
        }
        return null;
    }
}
