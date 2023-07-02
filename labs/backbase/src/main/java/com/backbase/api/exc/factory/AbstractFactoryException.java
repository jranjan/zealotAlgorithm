package com.backbase.api.exc.factory;

import com.backbase.api.exc.BackbaseException;

/**
 * See {@link BackbaseException} to understand where and how to use this exception's
 * constructors and the overridden set(String, Object) method.
 *
 * @author jyoti.ranjan
 */
public class AbstractFactoryException extends BackbaseException {

  public AbstractFactoryException(AbstractFactoryErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public AbstractFactoryException(
      Throwable cause, AbstractFactoryErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public AbstractFactoryException set(String key, Object value) {
    return (AbstractFactoryException) super.set(key, value);
  }
}
