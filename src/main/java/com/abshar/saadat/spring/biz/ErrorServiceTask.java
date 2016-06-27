package com.abshar.saadat.spring.biz;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by hovaheb on 6/24/2016.
 */
public class ErrorServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        if (execution.hasVariable("throwError") &&
                Boolean.valueOf(execution.getVariable("throwError").toString())) {
            throw new IllegalArgumentException("Rollback!!");
        }
    }
}
