package com.backbase.api.exc.executor;

import com.backbase.api.exc.BackbaseException;

/**
 * See {@link BackbaseException} to understand where and how to use this exception's constructors and the
 * overridden set(String, Object) method.
 *
 * @author jyoti.ranjan
 */
public class ExecutorEngineException extends BackbaseException {

  public ExecutorEngineException(ExecutorEngineErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public ExecutorEngineException(
      Throwable cause, ExecutorEngineErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public ExecutorEngineException set(String key, Object value) {
    return (ExecutorEngineException) super.set(key, value);
  }
}
