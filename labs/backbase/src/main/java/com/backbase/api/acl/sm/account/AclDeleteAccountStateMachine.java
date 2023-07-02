package com.backbase.api.acl.sm.account;

import com.backbase.api.acl.data.account.BackendAccountNumberPayload;
import com.backbase.api.acl.data.account.BackendAccountPayload;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.controller.v1.response.account.AccountInfo;
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
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::deleteAccountState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult deleteAccountState(StateMachineRequest request, Hint hint) {
    try {
      // Get request payload
      BackendAccountNumberPayload requestPayload = (BackendAccountNumberPayload) request.getRequestData();

      // Prepare the response
      BackendAccountPayload responsePayload = new BackendAccountPayload();
      AccountInfo accountInfo = new AccountInfo();
      accountInfo.setAccountNumber(requestPayload.getAccountNumber());
      accountInfo.setAccountType("SAVING");

      // Set response payload
      responsePayload.setAccountInfo(accountInfo);
      request.setResponseData(responsePayload);

      // Move to next state, as everything went good
      request.setNextState(this::successState);
    } catch (Exception ex) {
      log.error("Unable to delete service instance", ex);
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }
}
