package com.backbase.api.exc.executor;

import com.backbase.api.exc.IBackbaseErrorMessage;
public enum ExecutorEngineErrorMessage implements IBackbaseErrorMessage {
  FAILED_TO_CREATE_STATE_MACHINE_EXECUTOR_ENGINE("Failed to create StateMachineExecutorEngine");

  private final String messageFormat;

  ExecutorEngineErrorMessage(String messageFormat) {
    this.messageFormat = messageFormat;
  }

  @Override
  public String getMessageFormat() {
    return messageFormat;
  }
}
