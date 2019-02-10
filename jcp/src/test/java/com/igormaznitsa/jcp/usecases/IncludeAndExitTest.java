/*
 * Copyright 2002-2019 Igor Maznitsa (http://www.igormaznitsa.com)
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.igormaznitsa.jcp.usecases;

import com.igormaznitsa.jcp.JcpPreprocessor;
import com.igormaznitsa.jcp.context.PreprocessorContext;

import static org.junit.Assert.assertEquals;

public class IncludeAndExitTest extends AbstractUseCaseTest {

  @Override
  public void check(final PreprocessorContext context, final JcpPreprocessor.Statistics stat) throws Exception {
    assertEquals(0, stat.getCopied());
    assertEquals(1, stat.getPreprocessed());
  }

}
