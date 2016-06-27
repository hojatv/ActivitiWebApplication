package com.abshar.saadat.spring.rest.services;

import com.abshar.saadat.spring.controller.RestURIConstants;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.Task;
import org.activiti.rest.service.api.runtime.task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hovaheb on 6/21/2016.
 */

@Controller
public class TaskResource {
    @Autowired
    private TaskService taskService;

    @Transactional
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
