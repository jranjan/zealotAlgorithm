package com.backbase.api.exc.openapi;

import com.backbase.api.exc.IBackbaseErrorMessage;

public enum OpenApiSpecificationErrorMessage implements IBackbaseErrorMessage {
  FAILED_TO_LOAD("Failed to load the specification.");

  private final String messageFormat;

  OpenApiSpecificationErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
