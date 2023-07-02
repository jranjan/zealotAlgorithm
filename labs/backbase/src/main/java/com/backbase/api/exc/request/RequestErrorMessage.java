package com.backbase.api.exc.request;

import com.backbase.api.exc.IBackbaseErrorMessage;

public enum RequestErrorMessage implements IBackbaseErrorMessage {
  FAILED_TO_PROCESS_REQUEST("Failed to process the request."),
  FAILED_TO_UPDATE_STATUS("Failed to update the status.");

  private final String messageFormat;

  RequestErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
