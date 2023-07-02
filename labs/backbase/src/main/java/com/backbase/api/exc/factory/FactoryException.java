package com.backbase.api.exc.factory;

import com.backbase.api.exc.BackbaseException;

/**
 * See {@link BackbaseException} to understand where and how to use this exception's constructors and the
 * overridden set(String, Object) method.
 *
 * @author jyoti.ranjan
 */
public class FactoryException extends BackbaseException {

  public FactoryException(FactoryErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public FactoryException(Throwable cause, FactoryErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public FactoryException set(String key, Object value) {
    return (FactoryException) super.set(key, value);
  }
}
