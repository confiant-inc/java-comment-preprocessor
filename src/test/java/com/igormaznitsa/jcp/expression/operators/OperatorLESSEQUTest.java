/* 
 * Copyright 2014 Igor Maznitsa (http://www.igormaznitsa.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.jcp.expression.operators;

import com.igormaznitsa.jcp.expression.ExpressionItemPriority;
import com.igormaznitsa.jcp.expression.Value;
import static org.junit.Assert.*;

public class OperatorLESSEQUTest extends AbstractOperatorTest {

  private static final OperatorLESSEQU HANDLER = new OperatorLESSEQU();

  @Override
  public void testKeyword() {
    assertEquals("<=", HANDLER.getKeyword());
  }

  @Override
  public void testReference() {
    assertReference(HANDLER);
  }

  @Override
  public void testArity() {
    assertEquals(2, HANDLER.getArity());
  }

  @Override
  public void testPriority() {
    assertEquals(ExpressionItemPriority.COMPARISON, HANDLER.getExpressionItemPriority());
  }

  @Override
  public void testExecution() throws Exception {
    assertExecution(Value.BOOLEAN_FALSE, "1<=0");
    assertExecution(Value.BOOLEAN_TRUE, "0<=0");
    assertExecution(Value.BOOLEAN_FALSE, "\"test\"<=\"t\"");
    assertExecution(Value.BOOLEAN_TRUE, "\"test\"<=\"test\"");
    assertExecution(Value.BOOLEAN_TRUE, "\"t\"<=\"test\"");
    assertExecution(Value.BOOLEAN_FALSE, "1.2<=1.1");
    assertExecution(Value.BOOLEAN_TRUE, "1.5<=2.3");
    assertExecution(Value.BOOLEAN_TRUE, "1.5<=1.5");
  }

  @Override
  public void testExecution_illegalState() throws Exception {
    assertIllegalStateException("<=");
    assertIllegalStateException("1<=");
    assertIllegalStateException("<=0");
  }

  @Override
  public void testExecution_illegalArgument() throws Exception {
    assertIllegalArgumentException("true<=\"test\"");
    assertIllegalArgumentException("true<=1");
    assertIllegalArgumentException("2.3<=\"test\"");
    assertIllegalArgumentException("2.3<=false");
    assertIllegalArgumentException("true<=false");
    assertIllegalArgumentException("1<=false");
  }

}
