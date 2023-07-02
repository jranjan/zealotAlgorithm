package com.backbase.api.exc.request;

import com.backbase.api.exc.BackbaseException;

/**
 * See {@link BackbaseException} to understand where and how to use this exception's constructors and the
 * overridden set(String, Object) method.
 *
 * @author jyoti.ranjan
 */
public class RequestException extends BackbaseException {

  public RequestException(RequestErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public RequestException(Throwable cause, RequestErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public RequestException set(String key, Object value) {
    return (RequestException) super.set(key, value);
  }
}
