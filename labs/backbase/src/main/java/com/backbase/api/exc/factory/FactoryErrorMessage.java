package com.backbase.api.exc.factory;

import com.backbase.api.exc.IBackbaseErrorMessage;


public enum FactoryErrorMessage implements IBackbaseErrorMessage {
  INVALID_OBJECT_TYPE("Invalid resource type={%s} provided"),
  FAILED_TO_CREATE_OBJECT("Virtual constructor failed to created object of type={%s}");

  private final String messageFormat;

  FactoryErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}

