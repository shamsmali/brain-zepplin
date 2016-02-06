/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.bigbrain;

import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;
import org.apache.zeppelin.interpreter.InterpreterUtils;
import org.apache.zeppelin.scheduler.Scheduler;
import org.apache.zeppelin.scheduler.SchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Properties;

/**
 * BigBrain interpreter for Zeppelin.
 */
public class BigBrain extends Interpreter {
  private CommandProcessor commandProcessor;
  static final Logger LOGGER = LoggerFactory.getLogger(BigBrain.class);

  static {
    Interpreter.register("bb", BigBrain.class.getName());
  }

  public BigBrain(Properties property) {
    super(property);
  }

  @Override
  public void open(){ commandProcessor = new CommandProcessor();}

  @Override
  public void close() {}

  @Override
  public InterpreterResult interpret(String st, InterpreterContext interpreterContext) {
    String text;
    try {
      text = commandProcessor.processCommand(st);
    } catch (java.lang.RuntimeException e) {
      LOGGER.error("Exception in Bigbrain while interpret ", e);
      return new InterpreterResult(Code.ERROR, InterpreterUtils.getMostRelevantMessage(e));
    }
    return new InterpreterResult(Code.SUCCESS, "%html " + text);
  }

  @Override
  public void cancel(InterpreterContext context) {}

  @Override
  public FormType getFormType() {
    return FormType.SIMPLE;
  }

  @Override
  public int getProgress(InterpreterContext context) {
    return 0;
  }

  @Override
  public Scheduler getScheduler() {
    return SchedulerFactory.singleton().createOrGetParallelScheduler(
            BigBrain.class.getName() + this.hashCode(), 5);
  }

  @Override
  public List<String> completion(String buf, int cursor) {
    return null;
  }
}
