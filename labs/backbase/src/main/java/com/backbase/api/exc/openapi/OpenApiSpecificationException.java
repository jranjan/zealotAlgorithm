package com.backbase.api.exc.openapi;

import com.backbase.api.exc.BackbaseException;

public class OpenApiSpecificationException extends BackbaseException {

  public OpenApiSpecificationException(
      OpenApiSpecificationErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public OpenApiSpecificationException(
      Throwable cause, OpenApiSpecificationErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public OpenApiSpecificationException set(String key, Object value) {
    return (OpenApiSpecificationException) super.set(key, value);
  }
}
