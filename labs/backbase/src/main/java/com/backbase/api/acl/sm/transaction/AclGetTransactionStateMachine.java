package com.backbase.api.acl.sm.transaction;

import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import org.springframework.stereotype.Component;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;

@Component
public class AclGetTransactionStateMachine extends AbstractStateMachine {

  public AclGetTransactionStateMachine(AclStateMachineRegistry stateMachineRegistry) {
    super(stateMachineRegistry);
  }

  @Override
  public IRequestType requestType() {
    return EnumAclRequestType.ACL_REQUEST_GET_TRANSACTION;
  }

  public EnumExecutorEngineResult collectDataState(StateMachineRequest request, Hint hint) {
    try {
      // TODO
    } catch (Exception exception) {
      request.setNextState(this::errorState);
    }

    return EXECUTOR_RESULT_CONTINUE;
  }
}
