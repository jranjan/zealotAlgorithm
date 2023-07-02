package com.backbase.api.acl.sm.account;

import com.backbase.api.common.executor.sm.AbstractStateMachine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;

@Component
@Slf4j
public class AclDeleteAccountStateMachine extends AbstractStateMachine {
  public AclDeleteAccountStateMachine(AclStateMachineRegistry stateMachineRegistry) {
    super(stateMachineRegistry);
  }

  @Override
  public IRequestType requestType() {
    return EnumAclRequestType.ACL_REQUEST_DELETE_ACCOUNT;
  }

  @Override
  public EnumExecutorEngineResult collectDataState(StateMachineRequest request, Hint hint) {
    try {
      // TODO
    } catch (Exception ex) {
      log.error("Unable to delete service instance", ex);
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }
}
