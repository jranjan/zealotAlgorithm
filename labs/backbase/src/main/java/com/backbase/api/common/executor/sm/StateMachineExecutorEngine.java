package com.backbase.api.common.executor.sm;

import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.IExecutorEngine;
import com.backbase.api.common.request.BackendRequest;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import org.springframework.stereotype.Component;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;
import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_WAITING;

public class StateMachineExecutorEngine implements IExecutorEngine {
  @Override
  public EnumExecutorEngineResult execute(BackendRequest request, Hint hint) {
    EnumExecutorEngineResult stateResult;
    StateMachineRequest stateMachineRequest = (StateMachineRequest) request;

    /*
     * The function can be called in two situations: (1) start and (2) callback.
     * As we start first time, we do not have next state configured and need to
     * start with current state. In case of callback, we have already processed
     * current state but went on waiting, need to invoke next state so that we
     * do not end up running same state twice.
     */
    if (null != stateMachineRequest.getPrevState()) {
      /*
       * We already started as previous state is not NULL. So,
       * we are entering again because of callback.
       */
      stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
      stateMachineRequest.setCurrState(stateMachineRequest.getNextState());
      stateMachineRequest.setNextState(null);
    }

    stateResult = stateMachineRequest.getCurrState().signature(stateMachineRequest, hint);
    while (EXECUTOR_RESULT_WAITING != stateResult) {
      stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
      stateMachineRequest.setCurrState(stateMachineRequest.getNextState());
      stateMachineRequest.setNextState(null);
      stateResult = stateMachineRequest.getCurrState().signature(stateMachineRequest, hint);

      /*
       *  Exercise specific activities if request is completed its processing.
       *  We are done with the processing of this request. So, let us do some
       *  sanity check and stay happy ever forever. In future, we might like
       *  to do more specialised processing.
       */
      if (EXECUTOR_RESULT_FINISHED == stateResult) {
        stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
        stateMachineRequest.setCurrState(null);
        return EXECUTOR_RESULT_FINISHED;
      }
    }
    return EXECUTOR_RESULT_WAITING;
  }
}
