package com.backbase.api.exc.manager;


public class SystemManagerException extends ManagerException {

  public SystemManagerException(SystemManagerErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public SystemManagerException(
      Throwable cause, SystemManagerErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }

  @Override
  public SystemManagerException set(String key, Object value) {
    return (SystemManagerException) super.set(key, value);
  }
}
