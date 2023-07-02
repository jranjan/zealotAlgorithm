package com.backbase.api.acl.sm.account;

import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import org.springframework.stereotype.Component;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;

@Component
public class AclCreateAccountStateMachine extends AbstractStateMachine {

  public AclCreateAccountStateMachine(AclStateMachineRegistry stateMachineRegistry) {
    super(stateMachineRegistry);
  }

  @Override
  public IRequestType requestType() {
    return EnumAclRequestType.ACL_REQUEST_CREATE_ACCOUNT;
  }


  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    try {
      // TODO
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult collectDataState(StateMachineRequest request, Hint hint) {
    try {
      // TODO
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult verifyResponseData(StateMachineRequest request, Hint hint) {
    try {
      request.setNextState(this::successState);
    } catch (Exception exception) {
      request.setNextState(this::errorState);
    }

    return EXECUTOR_RESULT_CONTINUE;
  }
}
