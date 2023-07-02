package com.backbase.api.acl.manager;

import com.backbase.api.acl.request.AclRequest;
import com.backbase.api.common.executor.IExecutorEngine;
import com.backbase.api.common.executor.sm.IStateMachine;
import com.backbase.api.common.executor.sm.IStateMachineRegistry;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.request.BackendRequest;
import com.backbase.api.common.utils.hint.Hint;
import com.backbase.api.exc.request.RequestErrorMessage;
import com.backbase.api.exc.request.RequestException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;

@Component
@ConditionalOnProperty(prefix = "acl", name = "manager", havingValue = "basic")
public final class BasicAclManager implements IAclManager {
  private final IStateMachineRegistry stateMachineRegistry;
  private final IExecutorEngine executorEngine;

  public BasicAclManager(IStateMachineRegistry aclStateMachineRegistry,
      IExecutorEngine executorEngine) {
    this.stateMachineRegistry = aclStateMachineRegistry;
    this.executorEngine = executorEngine;
  }

  @Override
  public void process(BackendRequest request, Hint hint) throws RequestException {
    AclRequest aclRequest = (AclRequest) request;
    IStateMachine stateMachine = this.stateMachineRegistry.getStateMachine(aclRequest.getType());
    aclRequest.setCurrState(stateMachine::zerothState);
    EnumExecutorEngineResult stateMachineResult = this.executorEngine.execute(aclRequest, null);
    if (EXECUTOR_RESULT_FINISHED != stateMachineResult) {
      throw new RequestException(RequestErrorMessage.FAILED_TO_PROCESS_REQUEST);
    }
  }
}
