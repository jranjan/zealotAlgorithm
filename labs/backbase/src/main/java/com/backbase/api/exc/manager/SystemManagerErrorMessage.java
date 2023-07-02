package com.backbase.api.exc.manager;

import com.backbase.api.exc.IBackbaseErrorMessage;
public enum SystemManagerErrorMessage implements IBackbaseErrorMessage {
  SYSTEM_MANAGER_NOT_FOUND("No system manager found.");

  private final String messageFormat;

  SystemManagerErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
