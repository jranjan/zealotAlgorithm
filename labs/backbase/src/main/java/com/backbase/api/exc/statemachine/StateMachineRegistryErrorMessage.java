package com.backbase.api.exc.statemachine;

import com.backbase.api.exc.IBackbaseErrorMessage;

public enum StateMachineRegistryErrorMessage implements IBackbaseErrorMessage {
  ;

  private final String messageFormat;

  StateMachineRegistryErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
