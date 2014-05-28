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
package com.igormaznitsa.jcp.directives;

import com.igormaznitsa.jcp.context.PreprocessingState;
import com.igormaznitsa.jcp.containers.PreprocessingFlag;
import com.igormaznitsa.jcp.context.PreprocessorContext;

/**
 * The class implements the //#_else directive handler
 *
 * @author Igor Maznitsa (igor.maznitsa@igormaznitsa.com)
 */
public class GlobalElseDirectiveHandler extends AbstractDirectiveHandler {

  @Override
  public String getName() {
    return "_else";
  }

  @Override
  public String getReference() {
    return "inverts the conditional flag for the current global //#_if..//#_else..//#_endif construction";
  }

  @Override
  public boolean isGlobalPhaseAllowed() {
    return true;
  }

  @Override
  public boolean isPreprocessingPhaseAllowed() {
    return false;
  }

  @Override
  public AfterDirectiveProcessingBehaviour execute(final String string, final PreprocessorContext context) {
    final PreprocessingState state = context.getPreprocessingState();
    if (state.isIfStackEmpty()) {
      throw new IllegalStateException(DIRECTIVE_PREFIX + "_else without " + DIRECTIVE_PREFIX + "_if detected");
    }

    if (state.isAtActiveIf()) {
      if (state.getPreprocessingFlags().contains(PreprocessingFlag.IF_CONDITION_FALSE)) {
        state.getPreprocessingFlags().remove(PreprocessingFlag.IF_CONDITION_FALSE);
      }
      else {
        state.getPreprocessingFlags().add(PreprocessingFlag.IF_CONDITION_FALSE);
      }
    }
    return AfterDirectiveProcessingBehaviour.PROCESSED;
  }

  @Override
  public boolean executeOnlyWhenExecutionAllowed() {
    return false;
  }

}
