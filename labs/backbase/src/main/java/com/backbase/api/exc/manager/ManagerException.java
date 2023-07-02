package com.backbase.api.exc.manager;

import com.backbase.api.exc.BackbaseException;
import com.backbase.api.exc.IBackbaseErrorMessage;

public abstract class ManagerException extends BackbaseException {

  public ManagerException(IBackbaseErrorMessage errorMessage, Object... arguments) {
    super(errorMessage, arguments);
  }

  public ManagerException(Throwable cause, IBackbaseErrorMessage errorMessage, Object... arguments) {
    super(cause, errorMessage, arguments);
  }
}
