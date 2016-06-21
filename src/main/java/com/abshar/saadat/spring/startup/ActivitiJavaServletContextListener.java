package com.abshar.saadat.spring.startup;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ActivitiJavaServletContextListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    ProcessEngines.init();
    ProcessEngine processEngine = ProcessEngineConfiguration
        .createStandaloneProcessEngineConfiguration()
        .setJdbcUrl("jdbc:mysql://localhost:3306/activiti?autoReconnect=true")
        .setJdbcDriver("com.mysql.jdbc.Driver")
        .setJdbcUsername("root")
        .setJdbcPassword("root")
        .setJobExecutorActivate(true)
        .buildProcessEngine();
    ProcessEngines.registerProcessEngine(processEngine);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    ProcessEngines.destroy();
  }

}
