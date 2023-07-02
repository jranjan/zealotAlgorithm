package com.backbase.api.exc.statemachine;

import com.backbase.api.exc.BackbaseException;

/**
 * See {@link BackbaseException} to understand where and how to use this exception's constructors and the
 * overridden set(String, Object) method.
 *
 * @author jyoti.ranjan
 */
public class StateMachineRegistryException extends BackbaseException {

  public StateMachineRegistryException(
      StateMachineRegistryErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public StateMachineRegistryException(
      Throwable cause, StateMachineRegistryErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public StateMachineRegistryException set(String key, Object value) {
    return (StateMachineRegistryException) super.set(key, value);
  }
}
