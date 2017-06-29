/*
 * Copyright 2016 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.linkedin.drelephant.schedulers;

import com.linkedin.drelephant.configurations.scheduler.SchedulerConfigurationData;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.apache.hadoop.conf.Configuration;

import java.util.*;

/**
 * This class provides methods to load information specific to the Azkaban scheduler.
 */
public class PhoebusScheduler implements Scheduler {

  private static final Logger logger = Logger.getLogger(PhoebusScheduler.class);

//  public static final String AZKABAN_WORKFLOW_URL = "azkaban.link.workflow.url";
//  public static final String AZKABAN_JOB_URL = "azkaban.link.job.url";
//  public static final String AZKABAN_EXECUTION_URL = "azkaban.link.execution.url";
//  public static final String AZKABAN_ATTEMPT_URL = "azkaban.link.attempt.url";
//  public static final String AZKABAN_JOB_NAME = "azkaban.job.id";

  private String schedulerName;
  private String jobDefId;
  private String jobExecId;
  private String flowDefId;
  private String flowExecId;

  private String jobDefUrl;
  private String jobExecUrl;
  private String flowDefUrl;
  private String flowExecUrl;

  private String jobName;
  private int workflowDepth;


  public PhoebusScheduler(String appId, Properties properties, SchedulerConfigurationData schedulerConfData) {
    schedulerName = schedulerConfData.getSchedulerName();
    if (properties != null) {
      loadInfo(appId, properties);
    } else {
      // Use default value of data type
    }
  }

  private void loadInfo(String appId, Properties properties) {
  /*
      final String str = new Configuration().get("mapreduce.jobhistory.webapp.address");
    String _jhistoryWebAddr = "http://" + str + "/jobhistory/job/";
    
    final String def = new Configuration().get("gaia.logger.stage");
    
    //def == null ? jobDefId = "jobDefId" : jobDefId = def;
    
    if (def == null)
      jobDefId = "jobDefId";
    else
      jobDefId = def;

   Set set=properties.entrySet();
   logger.info(String.format("affichage des valeurs de Properties : %s", set.toString()));
  
  
    // Update the 4 Ids
    jobDefId = properties.getProperty("gaia.logger.stage");  //CU6_Daily_Insertion
    jobExecId = appId; 
    flowDefId = "flowDefId"; 
    flowExecId = appId+" flowExecId";

    // For Azkaban, The url and ids are the same
    jobExecUrl = jobExecId;
    jobDefUrl = jobDefId;
    flowExecUrl = flowExecId;
    flowDefUrl = flowDefId;

    workflowDepth = 0; // TODO: Add sub-workflow support
    jobName = "jobName"; //properties.getProperty(AZKABAN_JOB_NAME);
    */
        jobDefId = properties.getProperty("gaia.logger.stage");  //CU6_Daily_Insertion "workplan"
    jobExecId = appId;
    flowDefId = "flowDefId";
    flowExecId = appId+" flowExecId";

    // For Azkaban, The url and ids are the same
    jobExecUrl = jobExecId;
    jobDefUrl = jobDefId;
    flowExecUrl = flowExecId;
    flowDefUrl = flowDefId;

    workflowDepth = 0; // TODO: Add sub-workflow support
    jobName = properties.getProperty("mapreduce.job.name"); //properties.getProperty(AZKABAN_JOB_NAME);
  }

  @Override
  public String getSchedulerName() {
    return schedulerName;
  }

  @Override
  public boolean isEmpty() {
    return jobDefId == null || jobExecId == null || flowDefId == null || flowExecId == null;
  }

  @Override
  public String getJobDefId() {
    return jobDefId;
  }

  @Override
  public String getJobExecId() {
    return jobExecId;
  }

  @Override
  public String getFlowDefId() {
    return flowDefId;
  }

  @Override
  public String getFlowExecId() {
    return flowExecId;
  }

  @Override
  public String getJobDefUrl() {
    return jobDefUrl;
  }

  @Override
  public String getJobExecUrl() {
    return jobExecUrl;
  }

  @Override
  public String getFlowDefUrl() {
    return flowDefUrl;
  }

  @Override
  public String getFlowExecUrl() {
    return flowExecUrl;
  }

  @Override
  public int getWorkflowDepth() {
    return workflowDepth;
  }

  @Override
  public String getJobName() {
    return jobName;
  }
}