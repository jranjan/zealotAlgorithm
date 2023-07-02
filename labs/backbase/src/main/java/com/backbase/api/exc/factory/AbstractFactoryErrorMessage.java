package com.backbase.api.exc.factory;

import com.backbase.api.exc.IBackbaseErrorMessage;

public enum AbstractFactoryErrorMessage implements IBackbaseErrorMessage {
  ;

  private final String messageFormat;

  AbstractFactoryErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
