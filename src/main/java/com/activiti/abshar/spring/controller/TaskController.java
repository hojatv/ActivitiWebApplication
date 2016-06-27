package com.activiti.abshar.spring.controller;

import com.activiti.abshar.spring.controller.RestURIConstants;
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
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = RestURIConstants.GET_TASKS,params = {"taskId"},method = RequestMethod.GET)
    public
    @ResponseBody
    TaskResponse getTasks(String taskId) {
        /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();*/
        Task task = taskService
                .createTaskQuery()
                .taskId(taskId)
                .singleResult();
        TaskResponse response = new TaskResponse(task);
        return response;
    }
}
