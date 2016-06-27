package com.abshar.saadat.spring.biz;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hovaheb on 6/24/2016.
 */
public class TransactionalBean {
    @Autowired
    private RuntimeService runtimeService;

    @Transactional
    public void execute(boolean throwError)
            throws Exception {
        runtimeService.startProcessInstanceByKey(
                "transactionTest");
        Map<String, Object> variableMap =
                new HashMap<String, Object>();
        variableMap.put("throwError", throwError);
        runtimeService.startProcessInstanceByKey(
                "transactionTest", variableMap);
    }
}
