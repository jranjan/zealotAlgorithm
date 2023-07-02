package com.backbase.api.common.executor.sm;

import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import lombok.extern.slf4j.Slf4j;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;
import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;

@Slf4j
public abstract class AbstractStateMachine implements IStateMachine {

  public AbstractStateMachine(IStateMachineRegistry stateMachineRegistry) {
    stateMachineRegistry.registerStateMachine(requestType(), this);
  }

  public abstract IRequestType requestType();

  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::successState);
    } catch (Exception e) {
      log.error("Exception occurred in collect data state", e);
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult successState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_COMPLETED);
      request.setNextState(this::finalState);
    } catch (Exception e) {
      log.error("Exception occurred in state machine", e);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  @Override
  public EnumExecutorEngineResult finalState(StateMachineRequest request, Hint hint) {
    return EXECUTOR_RESULT_FINISHED;
  }

  public EnumExecutorEngineResult errorState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_FAILED);
      request.setNextState(this::finalState);
    } catch (Exception ex) {
      log.error("Exception occurred in state machine", ex);
      return EXECUTOR_RESULT_CONTINUE;
    }
    return EXECUTOR_RESULT_CONTINUE;
  }
}
