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

package com.linkedin.drelephant.mapreduce.heuristics;

import com.linkedin.drelephant.configurations.heuristic.HeuristicConfigurationData;
import com.linkedin.drelephant.util.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.linkedin.drelephant.analysis.Heuristic;
import com.linkedin.drelephant.analysis.HeuristicResult;
import com.linkedin.drelephant.analysis.Severity;
import com.linkedin.drelephant.mapreduce.data.MapReduceCounterData;
import com.linkedin.drelephant.mapreduce.data.MapReduceApplicationData;
import com.linkedin.drelephant.mapreduce.data.MapReduceTaskData;
import com.linkedin.drelephant.math.Statistics;
import java.util.Map;
import org.apache.log4j.Logger;

import java.util.ArrayList;


import java.util.*;

import com.linkedin.drelephant.util.Utils;

/**
 * Analyses garbage collection efficiency
 */
public abstract class GenericHelloWorld implements Heuristic<MapReduceApplicationData> {

  private static final Logger logger = Logger.getLogger(GenericHelloWorld.class);
  private HeuristicConfigurationData _heuristicConfData;
  
    
    private static final String DEVIATION_SEVERITY = "standard_deviation_severity";
    private double[] deviationLimits = {5, 10, 15, 20};

  protected GenericHelloWorld(HeuristicConfigurationData heuristicConfData) {
    this._heuristicConfData = heuristicConfData;
  }
  
  protected abstract MapReduceTaskData[] getTasks(MapReduceApplicationData data);
  
  @Override
  public HeuristicConfigurationData getHeuristicConfData() {
    return _heuristicConfData;
  }

  @Override
  public HeuristicResult apply(MapReduceApplicationData data) {


    if(!data.getSucceeded()) {
      return null;
    }


    Severity severity;
    severity = Severity.NONE;
    
    HeuristicResult result = new HeuristicResult(_heuristicConfData.getClassName(),
                                                 _heuristicConfData.getHeuristicName(),
                                                 severity,
                                                 Utils.getHeuristicScore(severity, 0));

    result.addResultDetail("To do: ", "nothing to do!");

    return result;
  }
}
