package com.backbase.api.common.executor.sm;

import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;

public interface IStateMachine {

  EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint);

  EnumExecutorEngineResult successState(StateMachineRequest request, Hint hint);

  EnumExecutorEngineResult finalState(StateMachineRequest request, Hint hint);
}
