package com.backbase.api.acl.sm.account;

import com.backbase.api.acl.data.account.BackendAccountNumberPayload;
import com.backbase.api.acl.data.account.BackendAccountPayload;
import com.backbase.api.acl.data.account.BackendCreateAccountPayload;
import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.common.data.BackbaseGlobalData;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import com.backbase.api.controller.v1.request.account.AccountCreationInput;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
      request.setStatus(BackendRequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::createAccountState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult createAccountState(StateMachineRequest request, Hint hint) {
    try {
      // Get request payload
      BackendCreateAccountPayload requestPayload = (BackendCreateAccountPayload) request.getRequestData();
      AccountCreationInput userAccountInput = requestPayload.getAccountCreationInput();

      // Prepare the response
      BackendAccountPayload responsePayload = new BackendAccountPayload();
      AccountInfo accountInfo = new AccountInfo();
      accountInfo.setAccountNumber(UUID.randomUUID().toString());
      accountInfo.setAccountType("SAVING");
      accountInfo.setAccountHolderName(userAccountInput.getAccountHolderName());
      accountInfo.setAccountHolderMobile(userAccountInput.getAccountHolderMobile());
      accountInfo.setAccountHolderPrimaryEmail(userAccountInput.getAccountHolderPrimaryEmail());
      accountInfo.setDailyTransactionLimit(BackbaseGlobalData.MAX_DAILY_TRANSACTION_LIMIT);

      // Set response payload
      responsePayload.setAccountInfo(accountInfo);
      request.setResponseData(responsePayload);

      // Move to next state, as everything went good
      request.setNextState(this::successState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }
}
